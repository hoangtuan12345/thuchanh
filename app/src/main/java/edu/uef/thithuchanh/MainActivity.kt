package edu.uef.thithuchanh;
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.RelativeLayout
import android.widget.TextView

class MainActivity : Activity() {
    private lateinit var foodListView: ListView
    private lateinit var foodDetailLayout: RelativeLayout
    private lateinit var foodImage: ImageView
    private lateinit var foodName: TextView

    // Dữ liệu món ăn (tên và hình ảnh)
    private val foodNames = arrayOf(
        "Bread",
        "Cherry Cheesecake",
        "Gingerbread House",
        "Hamburger",
        "Sunny Side Up Eggs",
        "Beer",
        "Coconut Cocktail",
        "Lemonade",
        "Milk Shake",
        "Orange Juice"
    )
    private val foodDescriptions = arrayOf(
        "Bánh mì cỡ vừa",
        "Bánh kem dâu nhỏ",
        "Ngôi nhà bánh quy nhỏ",
        "Hamburger cỡ nhỏ",
        "Trứng ốp la thường",
        "Bia",
        "Nước dừa",
        "Nước chanh",
        "Sữa lắc",
        "Nước Cam"
    )

    private val foodImages = intArrayOf(
        R.drawable.bread,
        R.drawable.cherrycheesecake,
        R.drawable.gingerbreadhouse,
        R.drawable.hamburger,
        R.drawable.sunnysideupeggs,
        R.drawable.beer,
        R.drawable.coconutcocktail,
        R.drawable.lemonade,
        R.drawable.milkshake,
        R.drawable.orangejuice,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foodListView = findViewById(R.id.foodListView)
        foodDetailLayout = findViewById(R.id.foodDetailLayout)
        foodImage = findViewById(R.id.foodImage)
        foodName = findViewById(R.id.foodName)


        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, foodNames)
        foodListView.adapter = adapter


        foodListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            showFoodDetail(position)
        }
    }


    private fun showFoodDetail(position: Int) {
        foodImage.setImageResource(foodImages[position])
        foodName.text = foodDescriptions[position]
        foodDetailLayout.visibility = View.VISIBLE
    }

}
