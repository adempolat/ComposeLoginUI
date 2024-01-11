package com.adempolat.composeloginui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            login()
        }
    }

        @Preview
        @Composable
        fun login() {
            Column(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .paint(
                        painterResource(id = R.drawable.background_page),
                        contentScale = ContentScale.FillWidth
                    ), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ConstraintLayout(
                    Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                ) {
                    val (topText, culm) = createRefs()
                    Text(
                        text = "Login",
                        color = Color.White,
                        modifier = Modifier
                            .padding(top = 16.dp, start = 32.dp)
                            .constrainAs(topText) {
                                linkTo(parent.top, culm.top, bias = 0.6f)
                                linkTo(parent.start, parent.end, bias = 0f)
                            },
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Column(Modifier
                        .fillMaxWidth()
                        .height(600.dp)
                        .constrainAs(culm) {
                            bottom.linkTo(parent.bottom)
                        }
                        .background(
                            color = Color(android.graphics.Color.parseColor("#eff8f5")),
                            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                        )
                        .padding(32.dp)) {
                        Text(
                            text = "Email",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 16.dp),
                            color = Color.Black
                        )
                        var text by rememberSaveable { mutableStateOf("") }

                        TextField(
                            value = text,
                            onValueChange = {
                                text = it
                            },
                            label = { Text("example@gmail.com") },
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                backgroundColor = Color.White,
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent,
                                textColor = Color(android.graphics.Color.parseColor("#5E5E5E")),
                                unfocusedLabelColor = Color(android.graphics.Color.parseColor("#5E5E5E"))
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                                .background(Color.White, CircleShape),
                        )
                        Text(
                            text = "Password",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 16.dp),
                            color = Color.Black
                        )
                        var text2 by rememberSaveable { mutableStateOf("") }

                        TextField(
                            value = text2,
                            onValueChange = {
                                text2 = it
                            },
                            label = { Text("Type your Password") },
                            shape = RoundedCornerShape(10.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                backgroundColor = Color.White,
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent,
                                textColor = Color(android.graphics.Color.parseColor("#5E5E5E")),
                                unfocusedLabelColor = Color(android.graphics.Color.parseColor("#5E5E5E"))
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                                .background(Color.White, CircleShape),
                        )
                        Text(
                            "Forget Your Password?", fontSize = 14.sp,
                            modifier = Modifier
                                .padding(top = 24.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color(android.graphics.Color.parseColor("#5E5E5E"))
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 24.dp), verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .height(1.dp)
                                    .weight(1f)
                                    .background(Color(android.graphics.Color.parseColor("#4d4d4d")))
                            )
                            Text(
                                text = "Or Login With",
                                fontSize = 14.sp,
                                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                                color = Color(android.graphics.Color.parseColor("#4d4d4d"))
                            )
                            Box(
                                modifier = Modifier
                                    .height(1.dp)
                                    .weight(1f)
                                    .background(Color(android.graphics.Color.parseColor("#4d4d4d")))
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp)
                        ) {
                            Button(
                                onClick = { /*TODO*/ },
                                Modifier
                                    .padding(top = 10.dp, bottom = 10.dp, end = 8.dp)
                                    .weight(0.5f)
                                    .height(55.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.Transparent,
                                ), shape = RoundedCornerShape(10.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(0.3f), verticalArrangement = Arrangement.Center
                                ) {
                                    Image(painter = painterResource(id = R.drawable.google),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .width(25.dp)
                                            .clickable { })
                                }
                                Column(
                                    modifier = Modifier
                                        .padding(start = 14.dp)
                                        .weight(0.7f),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.Start
                                ) {
                                    Text(
                                        text = "Google",
                                        color = Color(android.graphics.Color.parseColor("#2f4f86")),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                }

                            }
                            Button(
                                onClick = { /*TODO*/ },
                                Modifier
                                    .padding(top = 10.dp, bottom = 10.dp, start = 8.dp)
                                    .weight(0.5f)
                                    .height(55.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.Transparent,
                                ), shape = RoundedCornerShape(10.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(0.2f), verticalArrangement = Arrangement.Center
                                ) {
                                    Image(painter = painterResource(id = R.drawable.facebook),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .width(25.dp)
                                            .clickable { })
                                }
                                Column(
                                    modifier = Modifier
                                        .padding(start = 14.dp)
                                        .weight(0.8f),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.Start
                                ) {
                                    Text(
                                        text = "Facebook",
                                        color = Color(android.graphics.Color.parseColor("#2f4f86")),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                }

                            }

                        }
                        Button(
                            onClick = { /*TODO*/ }, Modifier
                                .padding(top = 16.dp, bottom = 16.dp)
                                .fillMaxWidth()
                                .height(55.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(android.graphics.Color.parseColor("#fa951a"))
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        {
                            Text(
                                text = "Login",
                                color = Color.White,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }

}

