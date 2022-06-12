package com.imali.app.addallocations

import com.imali.app.moneyreceived.BucketsK
import com.imali.app.moneyreceived.MoneyReceivedK
import com.imali.app.setters.SetterBucketK

class PutAllocationsInListK(val moneyReceived: MoneyReceivedK) {

    fun getAllocationList(): List<SetterBucketK> {
        var list: ArrayList<SetterBucketK> = ArrayList()

        list.add(SetterBucketK(moneyReceived.getNecessities(), BucketsK.Necessities))
        list.add(SetterBucketK(moneyReceived.getEmergency(), BucketsK.Emergency))
        list.add(SetterBucketK(moneyReceived.getInvestment(), BucketsK.Investment))
        list.add(SetterBucketK(moneyReceived.getLearning(), BucketsK.Learning))
        list.add(SetterBucketK(moneyReceived.getFun(), BucketsK.Fun))

        //var setter = SetterBucketK(moneyReceived.getFun(), BucketsK.Emergency)

        return list
        /*return mutableListOf(
            SetterBucketK(moneyReceived.getNecessities(), BucketsK.Necessities),
            SetterBucketK(moneyReceived.getEmergency(), BucketsK.Emergency),
            SetterBucketK(moneyReceived.getInvestment(), BucketsK.Investment),
            SetterBucketK(moneyReceived.getLearning(), BucketsK.Learning),
            SetterBucketK(moneyReceived.getFun(), BucketsK.Fun)
        )*/
    }
}