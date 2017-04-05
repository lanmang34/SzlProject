package com.szl.test.test.surface;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;

import com.szl.test.R;
import com.szl.test.base.BaseActivity;
import com.szl.test.base.BaseApplication;
import com.szl.test.utils.AppUtil;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestSurfaceActivity extends BaseActivity implements SurfaceHolder.Callback{

    private SurfaceView sv_surface_view;
    private Camera mCamera;
    private Camera.Parameters mParameters;
    private ImageView iv_image;
    private List<Bitmap> bitmaps = new ArrayList<>();
    private int mCurrentTag;
    private boolean mIsRelease;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1 :
                    if (mCurrentBitmap != null) {
                        //bitmaps.add(mCurrentBitmap);
                        iv_image.setImageBitmap(mCurrentBitmap);
                    }
                    sendEmptyMessageDelayed(1, 300);
                    break;
            }
        }
    };
    private Bitmap mCurrentBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_surface);
        SurfaceView sv_surface_view = (SurfaceView) findViewById(R.id.sv_surface_view);
        iv_image = (ImageView)findViewById(R.id.iv_image);
        sv_surface_view.getHolder().addCallback(this);
        boolean caremaHardware = AppUtil.checkCaremaHardware(BaseApplication.getContext());
        Log.e("TAG", "摄像头状态 : " + caremaHardware);
    }

    public void showPicture(View v) {
        if (bitmaps.size() <= mCurrentTag) {
            Log.e("TAG", mCurrentTag +  "没有图片");
            return;
        }
        Bitmap bitmap = bitmaps.get(mCurrentTag++);
        if (bitmap != null) {
            iv_image.setImageBitmap(bitmap);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        try {
            try {
                mCamera = Camera.open(0);
            } catch (Exception e) {
                Log.e("TAG", "摄像头被占用");
            }
            if (mCamera == null) {
                Log.e("TAG", "摄像头为空");
                return;
            }
            mCamera.setPreviewDisplay(holder);
            Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() {
                @Override
                public void onPreviewFrame(byte[] data, Camera camera) {
                    decodeToBitMap(data, camera);
                }
            };
            mCamera.setPreviewCallback(previewCallback);
            mCamera.startPreview();
            mHandler.sendEmptyMessage(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        initCamera();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (mIsRelease) {
            return;
        }
        mIsRelease = true;
        mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        mCamera.setParameters(mParameters);
        holder.removeCallback(TestSurfaceActivity.this);
        mCamera.setPreviewCallback(null);
        stopCamera();
        mCamera.release();

        if (mCurrentBitmap!=null && !mCurrentBitmap.isRecycled()) {
            mCurrentBitmap.recycle();
        }
    }

    /* 相机初始化的method */
    private void initCamera() {
        if (mCamera != null) {
            try {
                mParameters = mCamera.getParameters();
                /*
                 * 设定相片大小为1024*768， 格式为JPG
                 */
                // parameters.setPictureFormat(PixelFormat.JPEG);
                mParameters.setPictureSize(320, 240);
                mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                mCamera.setParameters(mParameters);
                /* 打开预览画面 */
                mCamera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* 停止相机的method */
    private void stopCamera() {
        if (mCamera != null) {
            try {
                /* 停止预览 */
                mCamera.stopPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void decodeToBitMap(byte[] data, Camera _camera) {
        Camera.Size size = _camera.getParameters().getPreviewSize();
        try {
            YuvImage image = new YuvImage(data, ImageFormat.NV21, size.width,
                    size.height, null);
            Log.w("wwwwwwwww1", size.width + " " + size.height);
            if (image != null) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                image.compressToJpeg(new Rect(0, 0, size.width, size.height),
                        80, stream);
                Bitmap bmp = BitmapFactory.decodeByteArray(
                        stream.toByteArray(), 0, stream.size());
                Log.w("wwwwwwwww2", bmp.getWidth() + " " + bmp.getHeight());
                Log.w("wwwwwwwww3",
                        (bmp.getPixel(100, 100) & 0xff) + "  "
                                + ((bmp.getPixel(100, 100) >> 8) & 0xff) + "  "
                                + ((bmp.getPixel(100, 100) >> 16) & 0xff));

                stream.close();
                //iv_image.setImageBitmap(bmp);
                //addToList(bmp);
                mCurrentBitmap = bmp;
            }
        } catch (Exception ex) {
            Log.e("Sys", "Error:" + ex.getMessage());
        }
    }

    private void addToList(Bitmap bmp) {

    }


}
