package com.cryptodotcom.walletdashboard.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TotalBalanceCard(totalUsdValue: Double) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Total Balance",
                style = MaterialTheme.typography.h6,
                color = Color.Gray
            )
            Text(
                text = "$${String.format("%.2f", totalUsdValue)}",
                style = MaterialTheme.typography.h3,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TotalBalanceCardPreview() {
    MaterialTheme {
        TotalBalanceCard(totalUsdValue = 25700.0)
    }
}

@Preview(showBackground = true)
@Composable
fun TotalBalanceCardSmallValuePreview() {
    MaterialTheme {
        TotalBalanceCard(totalUsdValue = 123.45)
    }
}

@Preview(showBackground = true)
@Composable
fun TotalBalanceCardZeroValuePreview() {
    MaterialTheme {
        TotalBalanceCard(totalUsdValue = 0.0)
    }
}
