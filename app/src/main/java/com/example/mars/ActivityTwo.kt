package com.example.mars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mars.model.UserData
import com.example.mars.view.UserAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.app.Dialog
import androidx.fragment.app.DialogFragment
import java.util.jar.Attributes

class ActivityTwo : AppCompatActivity() {
    private lateinit var addsBtn:FloatingActionButton
    private lateinit var recv:RecyclerView
    private lateinit var userList: ArrayList<UserData>
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        userList = ArrayList()
        addsBtn = findViewById(R.id.addingBtn)
        recv = findViewById(R.id.mRecycler)
        userAdapter = UserAdapter(this, userList)
        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = userAdapter
        addsBtn.setOnClickListener { addInfo() }

        }

        private fun addInfo() {
        val inflter = LayoutInflater.from(this)
        val v = inflter.inflate(R.layout.add_item,null)
        val userName = v.findViewById<EditText>(R.id.userName)
        val userNo = v.findViewById<EditText>(R.id.userNo)
        val addDialog = AlertDialog.Builder(this)
        addDialog.setView(v)
        addDialog.setPositiveButton("Ok"){
            dialog, id ->
            val names = userName.text.toString()
            val number = userNo.text.toString()
            userList.add(UserData("Name: $names","Mobile No.: $number"))
            userAdapter.notifyDataSetChanged()
            dialog.dismiss()
            Toast.makeText(this, "Успешное добавление!", Toast.LENGTH_SHORT).show()

        }
        addDialog.setNegativeButton("Отмена"){
            dialog, id ->
            dialog.dismiss()
            Toast.makeText(this, "Отмена", Toast.LENGTH_SHORT).show()
        }
        addDialog.create()
        addDialog.show()

    }
}