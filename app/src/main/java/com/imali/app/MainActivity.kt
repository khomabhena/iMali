package com.imali.app

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.imali.app.addallocations.AddAllocationsK
import com.imali.app.addallocations.PutAllocationsInListK
import com.imali.app.moneyreceived.AllocateMoneyK
import com.imali.app.moneyreceived.BucketsK
import com.imali.app.moneyreceived.MoneyReceivedK
import com.imali.app.moneyreceived.PercentagesK
import com.imali.app.setters.SetterBucketK
import com.imali.app.spending.SpendingK

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    //+=%6

    lateinit var moneyReceived: MoneyReceivedK
    lateinit var listPreviousAllocations: List<SetterBucketK>
    lateinit var addAllocations: AddAllocationsK
    lateinit var list: List<SetterBucketK>
    var bucket: BucketsK? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        bNecessities.setOnClickListener { bucket = BucketsK.Necessities }
        bFun.setOnClickListener { bucket = BucketsK.Fun }
        bInvestment.setOnClickListener { bucket = BucketsK.Investment }
        bEmergency.setOnClickListener { bucket = BucketsK.Emergency }
        bLearning.setOnClickListener { bucket = BucketsK.Learning }

        bEnter.setOnClickListener {
            if (etMoneyReceived.text.isEmpty()) {
                Toast.makeText(this, "Enter Money Received", Toast.LENGTH_SHORT).show()
            } else {
                val money: Double = etMoneyReceived.text.toString().toDouble()
                moneyReceived = MoneyReceivedK(money)
                list = PutAllocationsInListK(moneyReceived).getAllocationList()
                tvNecessities.text = "$${moneyReceived.getNecessities()}"
                tvFun.text = "$" + moneyReceived.getFun()
                tvInvestment.text = "$" + moneyReceived.getInvestment()
                tvEmergency.text = "$" + moneyReceived.getEmergency()
                tvLearning.text = "$" + moneyReceived.getLearning()
                //Toast.makeText(this, ">><<" + allocation, Toast.LENGTH_SHORT).show()
            }
        }
        bEnterSpending.setOnClickListener {
            if (etSpending.text.toString().isEmpty())
                Toast.makeText(this, "Enter spending amount", Toast.LENGTH_SHORT).show()
            else {
                if (bucket == null)
                    Toast.makeText(this, "Select spending bucket", Toast.LENGTH_SHORT).show()
                else {
                    var spendingAmount = etSpending.text.toString().toDouble()
                    var spending = SpendingK(spendingAmount, bucket!!, list)
                    if (!spending.canAfford())
                        Toast.makeText(this, "Cannot Afford", Toast.LENGTH_SHORT).show()
                    else {
                        Toast.makeText(this, "Your change, $" + spending.getRemainingAmount(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }
}
