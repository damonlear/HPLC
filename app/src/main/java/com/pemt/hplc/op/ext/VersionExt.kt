package com.pemt.hplc.op.ext

import com.pemt.hplc.op.AppContext

fun getVersionName(): String {
    return AppContext.packageManager.getPackageInfo(AppContext.packageName, 0).versionName
}