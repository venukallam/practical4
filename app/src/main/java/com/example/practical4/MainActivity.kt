package com.example.practical4
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Button
class MainActivity : AppCompatActivity() {
    lateinit var btn_ref_browser: Button
    lateinit var btn_ref_maps: Button
    lateinit var btn_ref_camera: Button
    lateinit var btn_ref_alarm: Button
    lateinit var btn_ref_contacts: Button
    lateinit var btn_ref_gallery: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_ref_browser = findViewById(R.id.bt_browser)
        btn_ref_maps = findViewById(R.id.bt_maps)
        btn_ref_camera = findViewById(R.id.bt_camera)
        btn_ref_alarm = findViewById(R.id.bt_alarm)
        btn_ref_contacts = findViewById(R.id.bt_contact)
        btn_ref_gallery = findViewById(R.id.bt_gallery)
        ImplicitIntent()
    }
    fun ImplicitIntent(){
        btn_ref_browser.setOnClickListener {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com")).also {
                startActivity(it)
            }
        }
        btn_ref_maps.setOnClickListener {
            val addUri: Uri = Uri.parse("geo:0,0??="+"Hyderabad")
            val i1 = Intent(Intent.ACTION_VIEW, addUri )
            startActivity(i1)
        }
        btn_ref_alarm.setOnClickListener{
            Intent(AlarmClock.ACTION_SHOW_ALARMS).also {
                startActivity(it)
            }
        }
        btn_ref_camera.setOnClickListener{
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
                startActivity(it)
            }
        }
        btn_ref_gallery.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType("image/*").also {
                startActivity(it)
            }
        }
        btn_ref_contacts.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(ContactsContract.Contacts.CONTENT_TYPE).also {
                startActivity(it)
            }
        }
    }}