package com.empower.dashboard

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.text.TextUtils
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.empower.R
import com.empower.app.MVVMBindingActivity
import com.empower.common.Constant
import com.empower.common.ManagePermissions
import com.empower.databinding.ActivityMainBinding
import com.empower.network.ViewModelFactoryClass
import com.example.tscdll.TSCActivity
import java.lang.Exception


class MainActivity : MVVMBindingActivity<ActivityMainBinding>(),OnClickListener {
    var TscDll = TSCActivity()
    private lateinit var viewModel: MainViewModel
    private lateinit var managePermissions: ManagePermissions
    private val REQUEST_CAMERA_CAPTURE = 1002
    private val permissionList = listOf(
        Manifest.permission.CAMERA,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    private var cNoteList= mutableListOf<TripSheetResponse.TripSheetDocketDetail>()
    private var cNote : TripSheetResponse.TripSheetDocketDetail?=null

    override fun initializeView() {
        managePermissions = ManagePermissions(this, permissionList, Constant.REQUEST_PERMISION)
        viewModel = ViewModelProvider(
            this,
            ViewModelFactoryClass(application)
        )[MainViewModel::class.java]
        binding?.let{
            it.ivDownload.setOnClickListener(this)
            it.ivCamera.setOnClickListener(this)
            it.barCode.setOnClickListener(this)


        }
        setObserver()
    }

    override fun provideViewResource(): Int {
        return R.layout.activity_main
    }

    private fun setObserver() {
        viewModel.pickupResponse.observe(this, Observer { it ->
            it?.run {
                if(TripsheetDocketCartonList.isNotEmpty()) {
                    binding?.run {
                        rvStickerList?.adapter = TripSheetAdapter(TripsheetDocketCartonList)
                        etTotalHu.setText(TripsheetDocketCartonList.size)
                    }
                }
                else Toast.makeText(this@MainActivity,"No Data",Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onClick(p0: View?) {

    }


}