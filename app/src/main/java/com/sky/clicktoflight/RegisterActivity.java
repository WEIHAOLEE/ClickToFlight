package com.sky.clicktoflight;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;
import com.sky.clicktoflight.utils.GetPhotoFromPhotoAlbum;
import com.sky.clicktoflight.utils.ImmersionBarUtils;
import com.sky.clicktoflight.utils.MyMD5Util;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;

import java.io.File;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class RegisterActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private ImageView mIvUserPhoto;
    private EditText mEtId;
    private EditText mEtPwd;
    private EditText mEtPwdConfirm;
    private Button mBtRegister;
    private String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
        submitRegister();
    }

    // 选择图片返回
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 1){
            if (data != null){
//                Uri imageUri = Uri.parse(GetPhotoFromPhotoAlbum.getRealPathFromUri(this,data.getData()));
                Uri imageUri = data.getData();
                photoClip(imageUri);
//                mIvUserPhoto.setImageURI(imageUri);
            }
        }else if(requestCode == UCrop.REQUEST_CROP && resultCode == RESULT_OK){
            Uri uri = UCrop.getOutput(data);
            mIvUserPhoto.setImageURI(uri);
//            Uri clipImage = data.getData();
//            mIvUserPhoto.setImageURI(clipImage);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void photoClip(Uri uri) {

        Uri cropUrl = Uri.fromFile(new File(getCacheDir(), "myCroppedImage.jpg"));
        UCrop uCrop = UCrop.of(uri, cropUrl);
        UCrop.Options options = new UCrop.Options();
        //设置裁剪图片可操作的手势
        options.setAllowedGestures(UCropActivity.SCALE, UCropActivity.ROTATE, UCropActivity.ALL);
        //设置toolbar颜色
        options.setToolbarColor(ActivityCompat.getColor(this, R.color.nav_color));
        //设置状态栏颜色
        options.setStatusBarColor(ActivityCompat.getColor(this, R.color.nav_color));
        //是否能调整裁剪框
        // options.setFreeStyleCropEnabled(true);
        uCrop.withAspectRatio(1,1);
        uCrop.withOptions(options);
        uCrop.start(this);

    }

    /**
     * 动态获取权限
     */
    private void getPermission(){
        if (EasyPermissions.hasPermissions(this,permissions)) {
            Toast.makeText(this,"Already have permissions", Toast.LENGTH_SHORT).show();
        }else {
            EasyPermissions.requestPermissions(this,"need you camera and storage permissions",1,permissions);
        }
    }
    private void submitRegister() {

        mIvUserPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPermission();
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
//                intent.setAction("android.intent.action.GET_CONTENT");
                startActivityForResult(intent,1);
            }
        });
        // TODO: 设置监听 并且检测密码输入是否一致 是否应该查询数据库检测是否有重复用户名
        mBtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 图片
                String uId = mEtId.getText().toString().trim();
                String uPwd = mEtPwd.getText().toString().trim();
                String uPwdConfirm = mEtPwdConfirm.getText().toString().trim();
                if (!TextUtils.isEmpty(uId) && !TextUtils.isEmpty(uPwd) && !TextUtils.isEmpty(uPwdConfirm)){
                    if (!uPwd.equals(uPwdConfirm)){
                        Toast.makeText(getApplicationContext(),"The two passwords do not match",Toast.LENGTH_SHORT).show();
                    }else {
                        // TODO: 提交注册申请
                        // 加密
                        MyMD5Util myMD5Util = new MyMD5Util();
                        String uPwdEnc = myMD5Util.encrypt(uPwd);

                    }
                }else {
                    Toast.makeText(getApplicationContext(),"You have not entered", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void initView() {
        ImmersionBarUtils immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilActivity(this,R.id.view_bar);
        mIvUserPhoto = findViewById(R.id.iv_user_photo);
        mEtId = findViewById(R.id.et_id);
        mEtPwd = findViewById(R.id.et_pwd);
        mEtPwdConfirm = findViewById(R.id.et_pwd_confirm);
        mBtRegister = findViewById(R.id.bt_register);
    }

    // easyPermissions callback 回调
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this);

    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        Toast.makeText(this,"get permissions successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Toast.makeText(this,"Please agree permissions, otherwise the function can't be used ", Toast.LENGTH_SHORT).show();
    }
}
