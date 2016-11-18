package com.szl.test.test.authcode;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.szl.test.R;
import com.szl.test.base.LogActivity;
import com.szl.test.utils.CodeUtil;

public class RandomAuthCodeActivity extends LogActivity {

    private ImageView iv_authcode;
    private EditText et_authcode;
    private String mCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_auth_code);
        iv_authcode = (ImageView) findViewById(R.id.iv_authcode);
        et_authcode = (EditText) findViewById(R.id.et_authcode);
    }

    public void replaceAuthCode(View v) {
        Bitmap bitmap = CodeUtil.getInstance().createBitmap();
        iv_authcode.setImageBitmap(bitmap);
        mCode = CodeUtil.getInstance().getAuthCode();
        setLog("验证码 = " + mCode);
    }

    public void checkAuthCode(View v) {
        boolean b = checkAuthCode();
        if (b) {
            setLog("验证码正确");
        }else{
            setLog("验证码错误");
        }
    }

    private boolean checkAuthCode() {
        if (!TextUtils.isEmpty(mCode)) {
            String inputCode = et_authcode.getText().toString().toLowerCase();
            if (inputCode.equals(mCode.toLowerCase())) {
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
