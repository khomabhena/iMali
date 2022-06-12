package com.imali.app.moneyreceived

class PercentagesK {
    //+=%6
    fun getPercentage(bucket: BucketsK): Double {
        return when (bucket) {
            BucketsK.Fun -> 0.1
            BucketsK.Emergency -> 0.1
            BucketsK.Investment -> 0.1
            BucketsK.Learning -> 0.1
            else -> 0.6
        }
    }
}