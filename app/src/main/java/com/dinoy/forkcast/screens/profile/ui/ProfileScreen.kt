package com.dinoy.forkcast.screens.profile.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.SwitchColors
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AlternateEmail
import androidx.compose.material.icons.outlined.ArtTrack
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.BookmarkAdded
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MarkEmailUnread
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dinoy.forkcast.R
import com.dinoy.forkcast.components.CustomisationTile
import com.dinoy.forkcast.components.CustomisationTileWithOutIcon
import com.dinoy.forkcast.components.CustomisationTileWithRadio
import com.dinoy.forkcast.components.DinoImage
import com.dinoy.forkcast.components.SettingsHeader
import com.dinoy.forkcast.components.TileSection
import com.dinoy.forkcast.components.TileSeparator
import com.dinoy.forkcast.ui.theme.interFontFamily
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen() {

    val context = LocalContext.current
    val packageManager = context.packageManager
    val info = packageManager.getPackageInfo(context.packageName, 0)
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        item {
            Spacer(Modifier.height(120.dp))
        }

        item {
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .border(
                        width = 1.dp,
                        color = Color.DarkGray.copy(alpha = .3f),
                        RoundedCornerShape(24.dp)
                    )
                    .clip(RoundedCornerShape(24.dp))
            )
            {
                DinoImage(imageUrl = "https://plus.unsplash.com/premium_photo-1661883237884-263e8de8869b?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cmVzdGF1cmFudHxlbnwwfHwwfHx8MA%3D%3D")
            }
        }

        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Text(
                    "Southern Delight",
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 23.sp,
                    color = Color.DarkGray
                )

                Text(
                    "Restaurant",
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    color = Color.DarkGray.copy(alpha = .6f)
                )
            }
        }


        item {
            androidx.compose.material3.Button(
                onClick = {},
                shape = RoundedCornerShape(24.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors().copy(
                    containerColor = Color.Black
                )
            ) {
                Text(
                    "Edit Profile",
                    modifier = Modifier.padding(vertical = 2.dp, horizontal = 2.dp),
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 13.sp,
                    color = Color.White.copy(alpha = .9f)
                )
            }
        }
        item {
            Spacer(Modifier.height(8.dp))
        }

        item {
            SettingsHeader("Basic Info")
        }

        item {
            TileSection {
                Column {
                    CustomisationTile(
                        iconContent = {
                            Icon(
                                imageVector = Icons.Outlined.Info,
                                contentDescription = "list",
                                tint = Color.DarkGray,
                                modifier = Modifier
                                    .size(16.dp),
                            )
                        },
                        title = "GST Info"
                    ) { }

                    TileSeparator()

                    CustomisationTile(
                        iconContent = {
                            Icon(
                                imageVector = Icons.Outlined.AlternateEmail,
                                contentDescription = "list",
                                tint = Color.DarkGray,
                                modifier = Modifier
                                    .size(16.dp),
                            )
                        },
                        title = "Email"
                    ) { }

                    TileSeparator()

                    CustomisationTile(
                        iconContent = {
                            Icon(
                                imageVector = Icons.Outlined.BookmarkAdded,
                                contentDescription = "list",
                                tint = Color.DarkGray,
                                modifier = Modifier
                                    .size(16.dp),
                            )
                        },
                        title = "Address"
                    ) { }

                    TileSeparator()

                    CustomisationTile(
                        iconContent = {
                            Icon(
                                imageVector = Icons.Outlined.ArtTrack,
                                contentDescription = "list",
                                tint = Color.DarkGray,
                                modifier = Modifier
                                    .size(16.dp),
                            )
                        },
                        title = "Customer Info"
                    ) { }
                }
            }
        }
        item {
            Spacer(Modifier.height(8.dp))
        }

        item {
            SettingsHeader("Preferences")
        }

        item {
            TileSection {
                Column {

                    var isDarkMode by remember { mutableStateOf(false) }
                    CustomisationTile(
                        title = "Dark Mode",
                        iconContent = {
                            Icon(
                                imageVector = Icons.Outlined.AutoAwesome,
                                contentDescription = "list",
                                tint = Color.DarkGray,
                                modifier = Modifier
                                    .size(16.dp),
                            )
                        },
                        trailingContent = {
                            Switch(
                                modifier = Modifier.padding(end = 8.dp),
                                checked = isDarkMode,
                                onCheckedChange = {
                                    isDarkMode = !isDarkMode
                                },
                                colors = androidx.compose.material3.SwitchDefaults.colors().copy(
                                    checkedThumbColor = Color.White,
                                    checkedTrackColor = Color.Black
                                )
                            )
                        }
                    )
                    {
                    }

                    TileSeparator()

                    var isPush by remember { mutableStateOf(true) }
                    CustomisationTile(
                        title = "Push Notification",
                        iconContent = {
                            Icon(
                                imageVector = Icons.Outlined.Notifications,
                                contentDescription = "list",
                                tint = Color.DarkGray,
                                modifier = Modifier
                                    .size(16.dp),
                            )
                        },
                        trailingContent = {
                            Switch(
                                modifier = Modifier.padding(end = 8.dp),
                                checked = isPush,
                                onCheckedChange = {
                                    isPush = !isPush
                                },
                                colors = androidx.compose.material3.SwitchDefaults.colors().copy(
                                    checkedThumbColor = Color.White,
                                    checkedTrackColor = Color.Black
                                )
                            )
                        }
                    )
                    {
                    }
                    TileSeparator()

                    var isEmail by remember { mutableStateOf(true) }
                    CustomisationTile(
                        title = "Push Notification",
                        iconContent = {
                            Icon(
                                imageVector = Icons.Outlined.MarkEmailUnread,
                                contentDescription = "list",
                                tint = Color.DarkGray,
                                modifier = Modifier
                                    .size(16.dp),
                            )
                        },
                        trailingContent = {
                            Switch(
                                modifier = Modifier.padding(end = 8.dp),
                                checked = isEmail,
                                onCheckedChange = {
                                    isEmail = !isEmail
                                },
                                colors = androidx.compose.material3.SwitchDefaults.colors().copy(
                                    checkedThumbColor = Color.White,
                                    checkedTrackColor = Color.Black
                                )
                            )
                        }
                    )
                    {
                    }
                }
            }
        }
        item {
            Spacer(Modifier.height(8.dp))
        }

        item {
            SettingsHeader("Support")
        }

        item {
            TileSection {
                Column {
                    CustomisationTileWithOutIcon(
                        title = "Contact Us"
                    ) { }

                    TileSeparator()

                    CustomisationTileWithOutIcon(
                        title = "Chat with us"
                    ) { }

                    TileSeparator()

                    CustomisationTileWithOutIcon(
                        title = "Privacy policy"
                    ) { }

                    TileSeparator()

                    CustomisationTileWithOutIcon(
                        title = "Terms and conditions"
                    ) { }
                }
            }
        }

        item {
            Spacer(Modifier.height(16.dp))
        }


        item {
            androidx.compose.material3.Button(
                modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(),
                onClick = {},
                shape = RoundedCornerShape(18.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors().copy(
                    containerColor = Color.Black
                )
            ) {
                Text(
                    "Log out",
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = .9f)
                )
            }
        }


        item {
            Spacer(Modifier.height(40.dp))
        }


        // app version name
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(R.string.forkcast),
                    color = Color.DarkGray.copy(alpha = .5f),
                    fontSize = 10.sp,
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Normal
                )

                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = stringResource(R.string.version, info.versionName.orEmpty()),
                    color = Color.DarkGray.copy(alpha = .7f),
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Medium,
                )
            }
        }


        item {
            Spacer(Modifier.height(120.dp))
        }
    }
}