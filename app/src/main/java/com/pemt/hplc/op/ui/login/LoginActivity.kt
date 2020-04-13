package com.pemt.hplc.op.ui.login

import com.pemt.hplc.op.R
import com.pemt.hplc.op.base.activity.BaseDataBindVMActivity
import com.pemt.hplc.op.base.viewmodel.BaseViewModel
import com.pemt.hplc.op.databinding.ActivityLoginBinding
import com.pemt.hplc.op.user.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseDataBindVMActivity<ActivityLoginBinding>() {
    private val mViewModel: UserViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.activity_login

    override fun initView() {

    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }
}