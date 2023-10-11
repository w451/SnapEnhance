package me.rhunk.snapenhance.common.config.impl

import me.rhunk.snapenhance.common.config.ConfigContainer
import me.rhunk.snapenhance.common.config.FeatureNotice

class Experimental : ConfigContainer() {
    val nativeHooks = container("native_hooks", NativeHooks()) { icon = "Memory"; requireRestart() }
    val spoof = container("spoof", Spoof()) { icon = "Fingerprint" }
    val appPasscode = string("app_passcode")
    val appLockOnResume = boolean("app_lock_on_resume")
    val infiniteStoryBoost = boolean("infinite_story_boost")
    val meoPasscodeBypass = boolean("meo_passcode_bypass")
    val unlimitedMultiSnap = boolean("unlimited_multi_snap") { addNotices(FeatureNotice.BAN_RISK)}
    val noFriendScoreDelay = boolean("no_friend_score_delay") { requireRestart()}
    val e2eEncryption = container("e2ee", E2EEConfig()) { requireRestart()}
    val hiddenSnapchatPlusFeatures = boolean("hidden_snapchat_plus_features") {
        addNotices(FeatureNotice.BAN_RISK, FeatureNotice.UNSTABLE)
        requireRestart()
    }
    val addFriendSourceSpoof = unique("add_friend_source_spoof",
        "added_by_username",
        "added_by_mention",
        "added_by_group_chat",
        "added_by_qr_code",
        "added_by_community",
    ) { addNotices(FeatureNotice.BAN_RISK) }
}