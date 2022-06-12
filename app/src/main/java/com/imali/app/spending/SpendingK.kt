package com.imali.app.spending

import com.imali.app.addallocations.AddAllocationsK
import com.imali.app.moneyreceived.BucketsK
import com.imali.app.setters.SetterBucketK

class SpendingK(var amount: Double, var bucket: BucketsK, var listAllocations: List<SetterBucketK>) {
    private var bucketTotal: Double = 0.0

    init {
        bucketTotal = AddAllocationsK(listAllocations, null).getBucketTotal(bucket)
    }

    fun canAfford(): Boolean {
        return amount < bucketTotal
    }

    fun getRemainingAmount() : Double {
        return bucketTotal - amount
    }
}