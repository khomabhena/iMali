package com.imali.app.addallocations

import com.imali.app.moneyreceived.BucketsK
import com.imali.app.setters.SetterBucketK

class AddAllocationsK(var list: List<SetterBucketK>, listPreviousAllocations: List<SetterBucketK>?)  {
    //+=%6
    init {
        list = if (listPreviousAllocations != null) list.plus(listPreviousAllocations) else list
    }

    fun getBucketTotal(bucket: BucketsK): Double {
        var total: Double = 0.0

        for (setter in list)
            if (setter.bucket == bucket)
                total += setter.amount

        return total
    }
}