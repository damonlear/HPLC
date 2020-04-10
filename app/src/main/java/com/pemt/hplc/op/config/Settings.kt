package com.pemt.hplc.op.config

import com.pemt.hplc.op.constant.Constant
import com.pemt.hplc.op.data.storage.Preference

object Settings {

    object Account {
        var token by Preference(Constant.USER_TOKEN, "")
        var userName by Preference(Constant.USER_NAME, "")
        var password by Preference(Constant.USER_PASSWORD, "")
    }
}