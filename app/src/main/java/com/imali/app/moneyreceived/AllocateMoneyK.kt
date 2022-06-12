package com.imali.app.moneyreceived

class AllocateMoneyK(val moneyReceived: Double) {
    //+=%6
    fun getAllocation(buckets: BucketsK): Double {
        val percentages = PercentagesK().getPercentage(buckets)
        val allocation: Double = percentages * moneyReceived

        return allocation
    }
}