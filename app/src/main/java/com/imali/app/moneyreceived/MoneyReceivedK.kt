package com.imali.app.moneyreceived

class MoneyReceivedK(var moneyReceived: Double) {

    //+=%6
    private  var necessities: Double = 0.0
    private  var emergency: Double = 0.0
    private  var investment: Double = 0.0
    private  var learning: Double = 0.0
    private  var funBucket: Double = 0.0
    private var money: Double = moneyReceived


    init {
        setAllocations()
    }

    private fun setAllocations() {
        val allocateMoney = AllocateMoneyK(money)
        necessities = allocateMoney.getAllocation(BucketsK.Necessities)
        emergency = allocateMoney.getAllocation(BucketsK.Emergency)
        investment = allocateMoney.getAllocation(BucketsK.Investment)
        learning = allocateMoney.getAllocation(BucketsK.Learning)
        funBucket = allocateMoney.getAllocation(BucketsK.Fun)
    }

    fun getNecessities(): Double {
        val allocateMoney = AllocateMoneyK(money)
        necessities = allocateMoney.getAllocation(BucketsK.Necessities)
        return necessities
    }

    fun getEmergency(): Double { return emergency }

    fun getInvestment(): Double { return investment  }

    fun getLearning(): Double { return learning }

    fun getFun(): Double { return funBucket }
}