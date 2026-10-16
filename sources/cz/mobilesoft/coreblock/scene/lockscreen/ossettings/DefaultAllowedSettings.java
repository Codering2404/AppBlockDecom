package cz.mobilesoft.coreblock.scene.lockscreen.ossettings;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DefaultAllowedSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DefaultAllowedSettings f105719a = new DefaultAllowedSettings();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set f105720b = SetsKt.setOf((Object[]) new String[]{"com.android.settings.SubSettings", "com.samsung.networkui.MobileNetworkSettings", "com.samsung.android.app.telephonyui.netsettings.ui.simcardmanager.SimCardMgrActivity", "com.samsung.android.secsoundpicker.SecSoundPickerActivity", "com.samsung.android.settings.personalvibration.VibPickerActivity", "com.sec.android.app.soundalive.activity.SoundAliveMainActivity", "com.sec.android.app.soundalive.SAControlPanelActivity", "com.samsung.android.settings.as.vibration.VibPickerActivity", "com.samsung.android.setting.multisound.MultiSoundSettingsActivity", "com.oneplus.dirac.simplemanager.SimpleManager", "com.oneplus.settings.ringtone.OPRingtonePickerActivity", "com.android.providers.media.RingtonePickerActivity", "com.android.settings.personalvibration.SelectPatternDialog", "com.android.settings.Settings$ConnectionsSettingsActivity", "com.android.settings.Settings$LanguageAndInputSettingsActivity", "com.samsung.android.app.telephonyui.netsettings.ui.NetSettingsActivity", "com.android.settings.Settings$WirelessSettingsActivity", "com.sec.android.app.camera.QrScannerActivity", "com.android.settings.Settings$WifiNetworkConnectActivity", "com.sec.android.app.soundalive.compatibility.Compatibility$Redirector", "com.samsung.android.net.wifi.wifiguider.activity.GuideApActivity", "com.samsung.android.net.wifi.wifiguider.activity.bluetooth.BluetoothGuideActivity", "com.android.settings.Settings$WifiQrCodeActivity", "com.sec.unifiedwfc.LaunchUnifiedActivity", "com.samsung.SMT.CheckVoiceData", "com.android.settings.password.ConfirmLockPassword", "com.samsung.android.app.sharelive.presentation.settings.SettingsActivity", "com.android.settings.Settings$WifiNetworkDetailsActivity", "com.android.settings.Settings$WifiApEditSettingsActivity", "com.google.android.projection.gearhead.companion.settings.DefaultSettingsActivity", "com.samsung.unifiedtp.ui.TetheringProvisionActivity", "com.android.settings.Settings$MotionAndGestureSettingsActivity", "com.sec.android.app.camera.Camera", "com.android.settings.password.ConfirmLockPattern", "com.android.permissioncontroller.permission.ui.GrantPermissionsActivity", "com.android.settings.bluetooth.BluetoothPairingDialog", "com.google.android.apps.inputmethod.latin.preference.SettingsActivity", "com.samsung.android.app.soundpicker.SoundPickerActivity", "com.samsung.android.settings.asbase.vibration.VibPickerContainer", "com.sec.android.app.simsettingmgr.NetworkManagement", "com.android.settings.Settings$PhysicalKeyboardActivity", "com.android.settings.localepicker.LocalePickerWithRegionActivity", "com.samsung.android.honeyboard.settings.common.HoneyBoardSettingsActivity", "com.samsung.android.settings.personalvibration.SelectPatternDialog", "com.samsung.android.app.omcagent.rna.ui.CBSettingActivity", "com.samsung.android.scloud.app.ui.SCloudActivity", "com.sec.android.app.soundalive.activity.EqualizerActivity", "com.android.camera.qrcodes.QRScannerActivity", "com.samsung.android.mdx.windowslink.tileservice.SeYourPhoneRelativeLinkBridgeActivity", "com.android.settings.Settings$IccLockSettingsActivity", "com.samsung.android.app.dressroom.presentation.settings.WallpaperSettingActivity", "com.wingos.wingcamera.QRScannerActivity", "com.android.settings.Settings$SoundSettingsActivity", "com.android.settings.wifi.dpp.WifiDppEnrolleeActivity", "com.google.android.apps.speech.tts.googletts.settings.asr.voiceime.ui.VoiceImeSettingsActivity", "com.samsung.android.app.telephonyui.netsettings.ui.multisim.DsaPhoneNumber", "com.samsung.android.app.telephonyui.netsettings.ui.multisim.DsaMainParser", "com.android.homescreen.settings.HomeScreenSettingsActivity", "com.android.launcher3.settings.DesktopSettingsActivity", "com.android.phone.callsettings.AnsweringCall", "com.samsung.android.scloud.app.ui.splash.SplashActivity", "com.samsung.android.sm.score.ui.ScoreBoardActivity", "com.sec.android.app.soundalive.SAControlPanelListActivity", "com.android.settings.Settings$ConfigureWifiSettingsActivity", "com.android.settings.Settings$NavigationBarSettingsInnerActivity", "com.android.settings.Settings$WifiAddNetworkActivity", "com.coloros.settings.feature.homepage.ColorSettingsHomepageActivity", "com.google.android.apps.youtube.app.application.Shell_SettingsActivity", "com.google.android.gms.app.settings.GoogleSettingsActivity", "com.google.android.gms.autofill.ui.AutofillSettingsActivity", "com.samsung.SMT.GetSampleText", "com.samsung.android.app.telephonyui.netsettings.ui.esim.LockMobilePlanActivity", "com.samsung.android.samsungaccount.authentication.ui.signup.view.AccountView", "com.samsung.android.samsungpassautofill.spass.SamsungPassHomeActivity", "com.samsung.android.settings.biometrics.fingerprint.FingerprintEntry", "com.samsung.ssu.unlock.MainActivity", "com.sec.android.app.soundalive.activity.DolbyAtmosActivity", "com.sec.unifiedwfc.ux.activities.VoWifiSettingsActivity", "com.android.settings.Settings$WifiAdvancedActivity", "com.android.settings.Settings$WifiNetworkModifyActivity", "com.sec.hearingadjust.activity.AdaptSoundMainActivity", "com.sec.hearingadjust.HearingdroPreset", "com.ts.camera.view.activity.QrScannerActivity", "com.android.settings.Settings$BluetoothCastSettingsActivity", "com.android.phone.MobileNetworkSettings", "com.sec.android.app.soundalive.DolbySettingsListActivity"});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f105721c = 8;

    private DefaultAllowedSettings() {
    }

    public final Set a() {
        return f105720b;
    }
}
