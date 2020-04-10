package com.pemt.hplc.op.ext

import com.pemt.hplc.op.config.Settings

fun isLogin(): Boolean = !Settings.Account.token.isBlank()

