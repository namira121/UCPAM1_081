package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun MainMenu(
    modifier: Modifier =Modifier
){
    var nama by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }
    val jenisKelamin = listOf("Laki-laki", "Perempuan")

    var namaUser by remember { mutableStateOf("") }
    var noHPUser by remember { mutableStateOf("") }
    var selectedGenderUser by remember { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize().padding(top=40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        BagianHeader(namaUser)
        Spacer(Modifier.padding(top = 30.dp))
        Text(text = "Yuk Lengkapi Data Dirimu!")
        Column (
            modifier=Modifier.padding(20.dp), horizontalAlignment = Alignment.Start
        ){
//            Row {
//                Text(text = "Yuk Lengkapi Data Dirimu!")
//            }
            OutlinedTextField(
//                Icon(Icons.Filled.Face,
//                    contentDescription = "",
//                    tint= Color.Black),
                value = nama,
                onValueChange = {nama = it},
                placeholder = { Text("Masukkan namamu") },
                label = { Text("Nama") },
                modifier = Modifier.fillMaxWidth().padding(5.dp),

            )
            OutlinedTextField(
//                Icon(Icons.Filled.Face,
//                    contentDescription = "",
//                    tint= Color.Black),
                value = noHp,
                onValueChange = {noHp = it},
                placeholder = { Text("Masukkan nomor teleponmu") },
                label = { Text("No Handphone") },
                modifier = Modifier.fillMaxWidth().padding(5.dp)
            )
            Spacer(Modifier.padding(10.dp))
            Row {
                Text(text = "Jenis Kelamin")
            }
            Row (
                horizontalArrangement = Arrangement.Start
            ){
                jenisKelamin.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = selectedGender == item,
                            onClick = {
                                selectedGender = item
                            })
                        Text(item)
                    }
                }
            }
            Button(modifier = Modifier.fillMaxWidth(),onClick = {
                namaUser = nama //membuat namaUser memiliki nilai yang sama dengan nama
                noHPUser = noHp
                selectedGenderUser = selectedGender
            }) { Text("Simpan") }

            Box(modifier=Modifier.padding(top= 15.dp).background(Color.LightGray, RoundedCornerShape(10)).size(width = 400.dp, height = 300.dp)){
                Column {
                    Row(modifier=Modifier.padding(9.dp)){
                        Text(text= "No Handphone")
                    }
                    Row() {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.padding(15.dp).background(Color.Cyan, RoundedCornerShape(20))
                        ) {
                            CardSectiontelpon(isiParam = noHPUser)
                        }
                    }
                    Row(modifier=Modifier.padding(8.dp)){
                        Text(text= "Jenis Kelamin")
                    }
                    Row() {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.padding(15.dp).background(Color.Cyan, RoundedCornerShape(20))
                        ) {
                            CardSectionGender(isiParam = selectedGenderUser)
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun BagianHeader(namaUser: String){
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Cyan, shape = RoundedCornerShape(bottomEnd = 50.dp))){
        Row(modifier = Modifier.padding(15.dp), verticalAlignment = Alignment.CenterVertically){
            Column() {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "", Modifier.padding(bottom = 20.dp),
                    tint = Color.White
                )
                Row {
                    Text(text = "Halo,", color = Color.White, fontSize = 60.sp)
                }
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(15.dp).background(Color.Cyan)
                ) {
                    CardSectionnama(isiParam = namaUser)
                }
            }
            Spacer(Modifier.padding(horizontal = 60.dp))
            Box(){
                Image(painter = painterResource(id = R.drawable.wendy),
                    contentDescription = "",
                    Modifier.size(100.dp).clip(shape = CircleShape))
            }
        }
    }
}

@Composable
fun CardSectiontelpon(isiParam:String){
    Column(){
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(contentAlignment = Alignment.BottomEnd){
                Icon(Icons.Filled.Phone,
                    contentDescription = "",
                    tint = Color.Black)
            }
            Text(text = " = ", modifier = Modifier.weight(0.2f))
            Text(text = "$isiParam",
                modifier = Modifier.weight(2f))
        }
    }
}

@Composable
fun CardSectionGender(isiParam:String){
    Column(){
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(contentAlignment = Alignment.BottomEnd){
                Icon(Icons.Filled.Person,
                    contentDescription = "",
                    tint = Color.Black)
            }
            Text(text = " = ", modifier = Modifier.weight(0.2f))
            Text(text = "$isiParam",
                modifier = Modifier.weight(2f))
        }
    }
}

@Composable
fun CardSectionnama(isiParam:String){
    Column(){
        Row(
            modifier = Modifier.size(height = 50.dp, width = 100.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "$isiParam",
                modifier = Modifier.weight(2f), fontSize = 50.sp, color = Color.White)
        }
    }
}

//@Composable
//fun CardSection(judulParam: String, isiParam:String){
//    Column(){
//        Row(
//            modifier = Modifier.fillMaxWidth().padding(8.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text(text = judulParam, modifier = Modifier.weight(0.8f))
//            Text(text = " = ", modifier = Modifier.weight(0.2f))
//            Text(text = "$isiParam",
//                modifier = Modifier.weight(2f))
//        }
//    }
//}