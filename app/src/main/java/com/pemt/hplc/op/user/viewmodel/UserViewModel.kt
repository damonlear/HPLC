package com.pemt.hplc.op.user.viewmodel

import androidx.lifecycle.MutableLiveData
import com.pemt.hplc.op.base.viewmodel.BaseViewModel
import com.pemt.hplc.op.user.model.UserInfoModel

class UserViewModel (): BaseViewModel() {

    val mUserInfoModel = MutableLiveData<UserInfoModel>()

}