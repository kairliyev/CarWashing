package kz.kairliyev.carwashing.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kz.kairliyev.carwashing.R

object UtilMethods {

    private lateinit var progressDialogBuilder: AlertDialog.Builder
    private lateinit var progressDialog: AlertDialog

    private val TAG: String = "---UtilMethods"

    fun showLoading(context: Context) {
        progressDialogBuilder = AlertDialog.Builder(context)
        progressDialogBuilder.setCancelable(false)
        progressDialogBuilder.setView(R.layout.layout_loading)

        progressDialog = progressDialogBuilder.create()
        progressDialog.show()
    }

    fun hideLoading() {
        try {
            progressDialog.dismiss()
        } catch (ex: java.lang.Exception) {
            Log.e(TAG, ex.toString())
        }

    }

    fun showLongToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }


    fun isConnectedToInternet(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val allNetworks = manager?.allNetworks?.let { it } ?: return false
            allNetworks.forEach { network ->
                val info = manager.getNetworkInfo(network)
                if (info.state == NetworkInfo.State.CONNECTED) return true
            }
        } else {
            val allNetworkInfo = manager?.allNetworkInfo?.let { it } ?: return false
            allNetworkInfo.forEach { info ->
                if (info.state == NetworkInfo.State.CONNECTED) return true
            }
        }
        return false
    }

}