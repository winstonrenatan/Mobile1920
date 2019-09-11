package com.github.winstonrenatan.loremgenerator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.github.winstonrenatan.loremgenerator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val loremIpsum: Ipsum = Ipsum("Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec bibendum facilisis lacus id varius. Aenean lacinia tempor neque, id vulputate sem blandit ut. Suspendisse imperdiet lorem ante, sed finibus justo aliquam vel. Etiam iaculis orci enim, vel finibus justo consequat vitae. Maecenas tincidunt, felis sed feugiat accumsan, velit augue dictum orci, non venenatis turpis lorem id tortor. In elit sapien, ultricies vel cursus id, rutrum ut massa. Vestibulum congue consequat nunc, a bibendum justo malesuada a. Aenean eu ipsum sed sapien feugiat mattis ac ac neque. Nunc diam erat, varius vel nibh quis, tempor scelerisque enim. Ut faucibus sed urna eget vestibulum. Phasellus semper sed libero non cursus. Nam aliquam metus sed ipsum pellentesque, non lobortis risus aliquet. Sed at molestie elit.\n" +
            "Donec faucibus mauris facilisis velit euismod hendrerit. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus consectetur eget nisi nec suscipit. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec tincidunt, ligula vulputate ullamcorper cursus, est turpis tristique ex, non feugiat ipsum lorem quis augue. Nam ut faucibus risus. Pellentesque eget dictum lacus, vel cursus sapien.\n" +
            "Maecenas nec malesuada risus, a tincidunt dolor. Pellentesque vel tincidunt tellus. Mauris eu aliquam ligula. Nam sit amet justo eget neque tincidunt pellentesque. Nulla id accumsan tortor. Phasellus erat enim, convallis et leo et, pretium dapibus est. Fusce eget ipsum rutrum, finibus diam eget, cursus ante. Sed a metus auctor, rutrum lectus vitae, ullamcorper ex. Nullam sit amet tempor tortor, sed vestibulum mi. Cras efficitur ex quis vehicula aliquet. Sed pretium nisl lectus, nec posuere lacus iaculis at. Quisque ut orci eu leo eleifend pellentesque vel ut magna. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed eu vestibulum tortor. Vestibulum mollis id diam sit amet feugiat.\n" +
            "Nullam luctus purus id iaculis iaculis. Cras sed egestas lacus, eget pulvinar odio. Fusce non malesuada mi. Quisque pharetra commodo elit in vestibulum. Mauris at felis a enim venenatis mattis non eu arcu. Suspendisse potenti. Nulla ac nibh vitae quam placerat tempor vitae quis metus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Maecenas hendrerit lorem a purus malesuada hendrerit. Nam fringilla purus ac finibus interdum. Nulla quis massa in eros luctus ultrices quis eget lacus. Etiam quis arcu non odio condimentum pharetra. Ut in ultrices felis, nec accumsan arcu. Donec ante lorem, tempor eu elementum id, pellentesque vel arcu. Vestibulum id nisi sed libero suscipit venenatis. Curabitur mi lorem, rhoncus nec rutrum eu, gravida ac erat.\n" +
            "Maecenas luctus facilisis mauris, nec aliquam eros aliquet id. Proin quis tortor ac purus faucibus ullamcorper. Nam vel urna a nibh consectetur mollis. Morbi hendrerit purus sit amet massa volutpat condimentum. In vitae lorem metus. Vivamus condimentum ex viverra orci rutrum faucibus. Praesent ornare lobortis nunc, imperdiet mattis arcu bibendum vel.\n")
    private val officeIpsum: Ipsum = Ipsum("Office Ipsum", "Hammer out (lets not try to) boil the ocean (here/there/everywhere) how much bandwidth do you have digitalize but run it up the flagpole,\n" +
            "ping the boss and circle back. Table the discussion re-inventing the wheel. Lets unpack that later can you send me an invite? peel the onion and lean into that problem . UX push back or target rich environment criticality or can you ballpark the cost per unit for me,\n" +
            "or it is all exactly as i said, but i dont like it, can we parallel path. Great plan! let me diarize this, and we can synchronise ourselves at a later timepoint. Helicopter view we just need to put these last issues to bed.\n" +
            "We need to touch base off-line before we fire the new ux experience dunder mifflin so are we in agreeance, so at the end of the day, nor strategic high-level 30,000 ft view. Player-coach collaboration through advanced technlogy for get six alpha pups in here for a focus group.\n" +
            "Tbrand terrorists anti-pattern, the last person we talked to said this would be ready its not hard guys we need a paradigm shift, good optics. Bells and whistles can I just chime in on that one. If you could do that, that would be great three-martini lunch,\n" +
            "nor player-coach imagineer roll back strategy. Cross functional teams enable out of the box brainstorming. When does this sunset? herding cats accountable talk. Flesh that out. ask drink from the firehose.")
    private val hipIpsum: Ipsum = Ipsum("Hip Ipsum", "Kickstarter biodiesel four loko, XOXO forage mixtape irony taiyaki banjo la croix retro. Venmo occupy vice chicharrones, actually umami PBR&B etsy banh mi godard pug try-hard. Enamel pin kale chips trust fund salvia tilde raclette kitsch hexagon banjo readymade mlkshk jianbing. La croix roof party tattooed, chicharrones chambray cardigan vape franzen mumblecore banjo church-key fixie health goth master cleanse williamsburg. Pour-over squid ennui, green juice farm-to-table aesthetic thundercats mixtape cornhole swag.\n" +
            "Live-edge austin pork belly meggings. Marfa jean shorts meditation wayfarers, messenger bag post-ironic small batch squid normcore man braid VHS cray celiac. Keytar put a bird on it food truck selfies. Wayfarers wolf austin beard lumbersexual butcher shoreditch pork belly PBR&B tote bag. Polaroid listicle single-origin coffee scenester, woke kale chips ugh microdosing irony.\n" +
            "Brunch skateboard stumptown, man bun organic blue bottle seitan vexillologist swag. Fingerstache lumbersexual 8-bit marfa messenger bag. La croix small batch paleo mlkshk roof party put a bird on it VHS pitchfork. Man bun shaman tattooed adaptogen distillery banjo. Knausgaard asymmetrical vinyl jean shorts yr. Whatever cloud bread coloring book tousled. Ennui occupy bitters brooklyn four dollar toast plaid celiac single-origin coffee copper mug stumptown lo-fi pop-up freegan 8-bit.")
    private val legalIpsum: Ipsum = Ipsum("Legal Ipsum", "For compatibility reasons, you are not covered by this License. Required Notices. You must make available, under the terms of this license is intended to facilitate the commercial use of the Copyright Holder. Version means the Original Code the copyright license to reproduce, \n" +
            "prepare derivative works of, publicly display, publicly perform, distribute and Externally Deploy Your Modifications and Covered Code, or any part of Covered Code may contain terms different from this License in accordance with FAR 12.211 (Technical Data) and 12.212 (Computer Software) and, for Department of Defense purchases, DFAR 252.227-7015 \n" +
            "(Technical Data -- Commercial Items) and 227.7202-3 (Rights in Commercial Computer Software or Computer Software or Computer Software Documentation). Accordingly, all U.S. Government End Users acquire Covered Code is available under various free culture licenses, consistent with the Derived Work without restriction, including without limitation, \n" +
            "any warranties or conditions of this License exceed the total costs of program errors, compliance with applicable laws, damage to or produced as output from the substance or structure of said Licensed Product.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.loremIpsum = loremIpsum
        binding.officeIpsum = officeIpsum
        binding.hipIpsum = hipIpsum
        binding.legalIpsum = legalIpsum

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.lorem_types, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.loremTypeSpinner.adapter = adapter

        binding.loremTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val currentType: String = binding.loremTypeSpinner.getItemAtPosition(position).toString()
                when (currentType) {
                    "Lorem Ipsum" -> {
                        binding.titleText.text = loremIpsum.type
                        binding.loremText.text = loremIpsum.content
                    }
                    "Office Ipsum" -> {
                        binding.titleText.text = officeIpsum.type
                        binding.loremText.text = officeIpsum.content
                    }
                    "Hip Ipsum" -> {
                        binding.titleText.text = hipIpsum.type
                        binding.loremText.text = hipIpsum.content
                    }
                    "Legal Ipsum" -> {
                        binding.titleText.text = legalIpsum.type
                        binding.loremText.text = legalIpsum.content
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("LoremGenerator :: ","onNothingSelected() is Called!")
            }
        }

        binding.creatorButton.setOnClickListener {
            pickCreatorName(binding.creatorButton)
        }
        binding.creatorText.setOnClickListener {
            changeCreatorName(it)
        }
    }

    private fun pickCreatorName(view: View) {
        binding.apply {
            creatorText.text = "created by: " + creatorFill.text.toString()
            creatorFill.visibility = View.GONE
            view.visibility = View.GONE
            loremTypeSpinner.visibility = View.GONE
            creatorText.visibility = View.VISIBLE
        }

        val tip = Toast.makeText(this, "Tap your name to change", Toast.LENGTH_SHORT)
        tip.setGravity(Gravity.CENTER, 0, -300)
        tip.show()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun changeCreatorName(view: View) {
        binding.apply {
            view.visibility = View.GONE
            creatorFill.visibility = View.VISIBLE
            creatorButton.visibility = View.VISIBLE
            loremTypeSpinner.visibility = View.VISIBLE
            creatorFill.requestFocus()
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.creatorFill, 0)
    }
}
