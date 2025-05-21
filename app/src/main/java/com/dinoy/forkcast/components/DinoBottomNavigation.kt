package com.dinoy.forkcast.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dinoy.forkcast.models.NavTabs
import com.dinoy.forkcast.ui.theme.interFontFamily


/**
 * **Slate Bottom navigation bar**
 *
 * @param modifier modifier that applied to navigation bar
 * @param items list of nav bar items
 * @param selectedIndex index of selected nav bar item
 * @param onClick call back when user click on nav bar item
 *
 * @see STNavigationBarItemConfig
 *
 */
@Composable
fun DinoBottomNavigationBar(
    modifier: Modifier = Modifier,
    items: List<NavTabs>,
    selectedIndex: Int = 0,
    onClick: (index: Int) -> Unit
) {

    Box(modifier = Modifier) {
        NavigationBar(modifier = modifier, containerColor = Color.White) {
            items.forEachIndexed { index, config ->
                BottomNavigationItem(
                    selected = index == selectedIndex,
                    onClick = {
                        onClick(index)
                    },
                    icon = {
                        // icon with badge
                        Box(modifier = Modifier.size(32.dp), contentAlignment = Alignment.Center)
                        {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(if (index == selectedIndex) config.selectedIcon else config.unSelectedIcon),
                                tint = if (index == selectedIndex) Color.Black else Color.LightGray,
                                contentDescription = ""
                            )
                        }
                    },
                    label = {
                        // item title
                        MinimumTextHeightHolder(
                            content = {
                                Text(
                                    text = stringResource(config.nameId),
                                    textAlign = TextAlign.Center,
                                    color = if (index == selectedIndex) Color.Black else Color.LightGray,
                                    fontFamily = interFontFamily,
                                    fontWeight = FontWeight.Medium
                                )
                            },
                            minHeight = 16.dp
                        )

                    }
                )
            }
        }

        // Separator
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = Color.LightGray.copy(alpha = .3f)
        )

    }
}


@Composable
fun MinimumTextHeightHolder(content: @Composable () -> Unit, minHeight: Dp) {
    Box(Modifier.heightIn(min = minHeight), contentAlignment = Alignment.Center)
    {
        content()
    }
}
