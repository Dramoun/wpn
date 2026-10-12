package com.example.wpn.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.wpn.R
import com.example.wpn.ui.theme.*

data class IconStyle(
  val icon: Painter,
  val contentDescription: String,
  val color: Color,
  val background: Color,
)

@Composable
fun AppIcon(
  modifier: Modifier = Modifier,
  style: IconStyle,
  size: Dp = 48.dp,
  hasBorder: Boolean = true,
  showIcon: Boolean = true,
  useIconStyleColors: Boolean = false,
) {
  val foregroundColor = if (useIconStyleColors) {
    style.color
  } else {
    MaterialTheme.colorScheme.primary
  }

  val backgroundColor = if (useIconStyleColors) {
    style.background
  } else {
    MaterialTheme.colorScheme.onPrimary
  }

  Box(
    modifier = modifier
      .size(size)
      .background(
        color = backgroundColor,
        shape = CircleShape
      )
      .border(
        width = if (hasBorder) 1.5.dp else 0.dp,
        color = foregroundColor.copy(alpha = 0.4f),
        shape = CircleShape
      ),
    contentAlignment = Alignment.Center
  ) {
    if (showIcon) {
      Icon(
        painter = style.icon,
        contentDescription = style.contentDescription,
        tint = foregroundColor,
        modifier = Modifier.size(size * 0.5f)
      )
    }
  }
}

enum class AppIconType {
  INCOME,
  EXPENSE,
  HOUSING,
  FOOD,
  TRANSPORT,
  SPORTS,
  GAMING,
  SUBSCRIPTIONS,
  SAVINGS,
  ALARM,
  FAVORITE,
  EXTENSION,
  LETTER_Y,
  LETTER_M,
  LETTER_W,
  LETTER_O,
  DASHBOARD,
  INSIGHTS,
  ADD,
  CLOSE,
  SEARCH,
  REFRESH,
  DELETE,
  ARROW_LEFT,
  ARROW_RIGHT,
  MENU,
  MORE,
}

@Composable
fun AppIconType.toStyle(): IconStyle = when (this) {
  AppIconType.INCOME -> AppIcons.Income()
  AppIconType.EXPENSE -> AppIcons.Expense()
  AppIconType.HOUSING -> AppIcons.Housing()
  AppIconType.FOOD -> AppIcons.Food()
  AppIconType.TRANSPORT -> AppIcons.Transport()
  AppIconType.SPORTS -> AppIcons.Sports()
  AppIconType.GAMING -> AppIcons.Gaming()
  AppIconType.SUBSCRIPTIONS -> AppIcons.Subscriptions()
  AppIconType.SAVINGS -> AppIcons.Savings()

  AppIconType.ALARM -> AppIcons.Alarm()
  AppIconType.FAVORITE -> AppIcons.Favorite()
  AppIconType.EXTENSION -> AppIcons.Extension()

  AppIconType.LETTER_Y -> AppIcons.LetterY()
  AppIconType.LETTER_M -> AppIcons.LetterM()
  AppIconType.LETTER_W -> AppIcons.LetterW()
  AppIconType.LETTER_O -> AppIcons.LetterO()

  AppIconType.DASHBOARD -> AppIcons.Dashboard()
  AppIconType.INSIGHTS -> AppIcons.Insights()

  AppIconType.ADD -> AppIcons.Add()
  AppIconType.CLOSE -> AppIcons.Close()
  AppIconType.SEARCH -> AppIcons.Search()
  AppIconType.REFRESH -> AppIcons.Refresh()
  AppIconType.DELETE -> AppIcons.Delete()

  AppIconType.ARROW_LEFT -> AppIcons.ArrowLeft()
  AppIconType.ARROW_RIGHT -> AppIcons.ArrowRight()

  AppIconType.MENU -> AppIcons.Menu()
  AppIconType.MORE -> AppIcons.More()
}

// https://fonts.google.com/icons
object AppIcons {
  @Composable
  fun Income() = IconStyle(
    icon = painterResource(R.drawable.payments_24px),
    contentDescription = "Income",
    color = SuccessColor,
    background = SuccessColor.copy(alpha = 0.15f),
  )

  @Composable
  fun Expense() = IconStyle(
    icon = painterResource(R.drawable.account_balance_wallet_24px),
    contentDescription = "Expense",
    color = ExpenseColor,
    background = ExpenseColor.copy(alpha = 0.15f),
  )

  @Composable
  fun Housing() = IconStyle(
    icon = painterResource(R.drawable.home_24px),
    contentDescription = "Housing",
    color = HousingColor,
    background = HousingColor.copy(alpha = 0.15f),
  )

  @Composable
  fun Food() = IconStyle(
    icon = painterResource(R.drawable.shopping_cart_24px),
    contentDescription = "Food",
    color = FoodColor,
    background = FoodColor.copy(alpha = 0.15f),
  )

  @Composable
  fun Transport() = IconStyle(
    icon = painterResource(R.drawable.directions_bus_24px),
    contentDescription = "Transport",
    color = TransportColor,
    background = TransportColor.copy(alpha = 0.15f),
  )

  @Composable
  fun Sports() = IconStyle(
    icon = painterResource(R.drawable.fitness_center_24px),
    contentDescription = "Sports",
    color = SportsColor,
    background = SportsColor.copy(alpha = 0.15f),
  )

  @Composable
  fun Gaming() = IconStyle(
    icon = painterResource(R.drawable.sports_esports_24px),
    contentDescription = "Gaming",
    color = GamingColor,
    background = GamingColor.copy(alpha = 0.15f),
  )

  @Composable
  fun Subscriptions() = IconStyle(
    icon = painterResource(R.drawable.subscriptions_24px),
    contentDescription = "Subscriptions",
    color = SubscriptionColor,
    background = SubscriptionColor.copy(alpha = 0.15f),
  )

  @Composable
  fun Savings() = IconStyle(
    icon = painterResource(R.drawable.savings_24px),
    contentDescription = "Savings",
    color = SavingsColor,
    background = SavingsColor.copy(alpha = 0.15f),
  )

  @Composable
  fun Alarm() = IconStyle(
    icon = painterResource(R.drawable.alarm_24px),
    contentDescription = "Reminder",
    color = AlarmColor,
    background = AlarmColor.copy(alpha = 0.15f),
  )

  @Composable
  fun Favorite() = IconStyle(
    icon = painterResource(R.drawable.favorite_24px),
    contentDescription = "Favorite",
    color = FavoriteColor,
    background = FavoriteColor.copy(alpha = 0.15f),
  )

  @Composable
  fun Extension() = IconStyle(
    icon = painterResource(R.drawable.extension_24px),
    contentDescription = "Extension",
    color = ExtensionColor,
    background = ExtensionColor.copy(alpha = 0.15f),
  )

  @Composable
  fun LetterY() = IconStyle(
    icon = painterResource(R.drawable.ic_letter_y),
    contentDescription = "Letter Y",
    color = LetterColor,
    background = LetterColor.copy(alpha = 0.15f),
  )

  @Composable
  fun LetterM() = IconStyle(
    icon = painterResource(R.drawable.ic_letter_m),
    contentDescription = "Letter M",
    color = LetterColor,
    background = LetterColor.copy(alpha = 0.15f),
  )

  @Composable
  fun LetterW() = IconStyle(
    icon = painterResource(R.drawable.ic_letter_w),
    contentDescription = "Letter W",
    color = LetterColor,
    background = LetterColor.copy(alpha = 0.15f),
  )

  @Composable
  fun LetterO() = IconStyle(
    icon = painterResource(R.drawable.ic_letter_o),
    contentDescription = "Letter O",
    color = LetterColor,
    background = LetterColor.copy(alpha = 0.15f),
  )

  @Composable
  fun Dashboard() = IconStyle(
    icon = painterResource(R.drawable.space_dashboard_24px),
    contentDescription = "Dashboard",
    color = MaterialTheme.colorScheme.onSurface,
    background = MaterialTheme.colorScheme.surface,
  )

  @Composable
  fun Insights() = IconStyle(
    icon = painterResource(R.drawable.pie_chart_24px),
    contentDescription = "Insights",
    color = MaterialTheme.colorScheme.onSurface,
    background = MaterialTheme.colorScheme.surface,
  )

  @Composable
  fun Add() = IconStyle(
    icon = painterResource(R.drawable.add_24px),
    contentDescription = "Add",
    color = MaterialTheme.colorScheme.onSurface,
    background = MaterialTheme.colorScheme.surface,
  )

  @Composable
  fun Close() = IconStyle(
    icon = painterResource(R.drawable.close_24px),
    contentDescription = "Close",
    color = MaterialTheme.colorScheme.onSurface,
    background = MaterialTheme.colorScheme.surface,
  )

  @Composable
  fun Search() = IconStyle(
    icon = painterResource(R.drawable.search_24px),
    contentDescription = "Search",
    color = MaterialTheme.colorScheme.onSurface,
    background = MaterialTheme.colorScheme.surface,
  )

  @Composable
  fun Refresh() = IconStyle(
    icon = painterResource(R.drawable.refresh_24px),
    contentDescription = "Refresh",
    color = MaterialTheme.colorScheme.onSurface,
    background = MaterialTheme.colorScheme.surface,
  )

  @Composable
  fun Delete() = IconStyle(
    icon = painterResource(R.drawable.delete_24px),
    contentDescription = "Delete",
    color = MaterialTheme.colorScheme.error,
    background = MaterialTheme.colorScheme.surface,
  )

  @Composable
  fun ArrowLeft() = IconStyle(
    icon = painterResource(R.drawable.keyboard_arrow_left_24px),
    contentDescription = "Previous",
    color = MaterialTheme.colorScheme.onSurface,
    background = MaterialTheme.colorScheme.surface,
  )

  @Composable
  fun ArrowRight() = IconStyle(
    icon = painterResource(R.drawable.keyboard_arrow_right_24px),
    contentDescription = "Next",
    color = MaterialTheme.colorScheme.onSurface,
    background = MaterialTheme.colorScheme.surface,
  )

  @Composable
  fun Menu() = IconStyle(
    icon = painterResource(R.drawable.menu_24px),
    contentDescription = "Menu",
    color = MaterialTheme.colorScheme.onSurface,
    background = MaterialTheme.colorScheme.surface,
  )

  @Composable
  fun More() = IconStyle(
    icon = painterResource(R.drawable.more_horiz_24px),
    contentDescription = "More",
    color = MaterialTheme.colorScheme.onSurface,
    background = MaterialTheme.colorScheme.surface,
  )
}
