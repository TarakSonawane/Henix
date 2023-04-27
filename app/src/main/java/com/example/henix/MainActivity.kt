package com.example.henix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.henix.Models.ApiResponse
import com.example.henix.Retrofit.ServiceBuilder
import com.example.henix.Retrofit.ServiceInterface
import com.example.henix.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getnews()

        binding.refreshButton.setOnClickListener{
            getnews()
        }
    }


    private fun getnews() {

        binding.factValue.text = "Fetching..."
        binding.lenValue.text = "Fetching..."

        val retrofit = ServiceBuilder.buildService(ServiceInterface::class.java)
        val details: Call<ApiResponse> = retrofit.gettallinfo()

        details.enqueue(object : Callback<ApiResponse>
        {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                try {
                    val responsee=response.body()!!

                    binding.factValue.text = responsee.fact.toString()
                    binding.lenValue.text = responsee.length.toString()


                }
                catch (ex: java.lang.Exception){
                    ex.printStackTrace()

                }

            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })

    }

}