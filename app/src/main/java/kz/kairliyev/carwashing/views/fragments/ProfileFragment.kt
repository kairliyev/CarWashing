package kz.kairliyev.carwashing.views.fragments


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_profile.*

import kz.kairliyev.carwashing.R
import kz.kairliyev.carwashing.models.User
import kz.kairliyev.carwashing.views.activities.auth.LoginActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ProfileFragment : Fragment() {

    var uid: String? = null
    var user: User? = null
    var mUser: User? = null
    var username: String? = ""
    var image: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        uid = FirebaseAuth.getInstance().uid
        fetchUsers()


        sign_out.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(it.context, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    private fun fetchUsers() {
        val ref = FirebaseDatabase.getInstance().getReference("/users")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot) {

                p0.children.forEach {
                    user = it.getValue(User::class.java)
                    if (user?.uid == uid) {
                        username = user?.username
                        image = user?.profileImageUrl
                        componentBind(username, image)
                        Log.d("Profile", username)
                    }
                }

            }

            override fun onCancelled(p0: DatabaseError) {

            }
        })


    }

    private fun componentBind(username: String?, image: String?) {
        Picasso.get().load(image).into(profile_image_view)
        profile_username_tv.text = username
    }

}
