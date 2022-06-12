import com.imali.app.addallocations.AddAllocationsK
import com.imali.app.addallocations.PutAllocationsInListK
import com.imali.app.moneyreceived.MoneyReceivedK
import com.imali.app.setters.SetterBucketK

class MainK {
    //+=%6

    lateinit var moneyReceived: MoneyReceivedK
    lateinit var listPreviousAllocations: List<SetterBucketK>
    lateinit var addAllocations: AddAllocationsK
    lateinit var list: List<SetterBucketK>

    init {
        moneyReceived = MoneyReceivedK(700.0)
        var allocationList = PutAllocationsInListK(moneyReceived)
        list = allocationList.getAllocationList()

        listPreviousAllocations = mutableListOf()
        for (x in 20..200 step 8)
            listPreviousAllocations.toMutableList().addAll(
                PutAllocationsInListK(MoneyReceivedK(x.toDouble())).getAllocationList())

        addAllocations = AddAllocationsK(list, listPreviousAllocations)
    }

    fun main(args: Array<String>) {
        print("Kholwani")
    }

}