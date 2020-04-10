package com.pemt.hplc.op.ui.welcome

//import com.fmt.github.home.activity.HomeActivity
//import com.fmt.github.user.activity.LoginActivity

import android.content.Intent
import androidx.lifecycle.lifecycleScope
import com.afollestad.assent.AssentResult
import com.afollestad.assent.Callback
import com.afollestad.assent.Permission
import com.jaredrummler.android.widget.AnimatedSvgView
import com.pemt.hplc.op.R
import com.pemt.hplc.op.base.activity.BaseDataBindActivity
import com.pemt.hplc.op.databinding.ActivityWelcomeBinding
import com.pemt.hplc.op.ext.getVersionName
import com.pemt.hplc.op.ext.otherwise
import com.pemt.hplc.op.ext.runWithPermissions
import com.pemt.hplc.op.ext.yes
import com.pemt.hplc.op.user.dao.UserDao
import kotlinx.android.synthetic.main.activity_welcome.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class WelcomeActivity : BaseDataBindActivity<ActivityWelcomeBinding>() {

    private val mUserDao: UserDao by inject()

    override fun getLayoutId(): Int = R.layout.activity_welcome

    override fun initView() {
        mAnimatedSvgView.setViewportSize(512f, 512f)
        mAnimatedSvgView.setOnStateChangeListener {
            (it == AnimatedSvgView.STATE_FINISHED).yes {
                askForPermission()
            }
        }
        mAnimatedSvgView.start()
    }

    override fun initData() {
        mDataBind.versionName = getVersionName()
    }

    private fun askForPermission() {
        runWithPermissions(Permission.READ_PHONE_STATE, granted = object : Callback {
            override fun invoke(result: AssentResult) {
                checkIsLogin()
            }
        }, denied = object : Callback {
            override fun invoke(result: AssentResult) {
//                finish()
            }
        })
    }

    private fun checkIsLogin() {
        lifecycleScope.launch {
            delay(500)//挂起,但不会阻塞,后续通过resumeWith恢复执行
            val userList = mUserDao.getAll()
            (userList.isEmpty()).yes {
//                go2Activity(LoginActivity::class.java)
            }.otherwise {
//                go2Activity(HomeActivity::class.java)
            }
        }
    }

    private fun go2Activity(clazz: Class<*>) {
        Intent(this@WelcomeActivity, clazz).run {
            startActivity(this)
            finish()
        }
    }
}