package androidx.credentials.provider;

import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.app.slice.SliceSpec;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.credentials.provider.utils.CryptoObjectUtils;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CreateEntry {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f35295i = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f35296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PendingIntent f35297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Icon f35298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CharSequence f35299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Instant f35300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f35301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f35302g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final BiometricPromptData f35303h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    private static final class Api28Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api28Impl f35304a = new Api28Impl();

        private Api28Impl() {
        }

        public static final Slice c(CreateEntry createEntry) {
            Intrinsics.checkNotNullParameter(createEntry, "createEntry");
            Slice sliceBuild = f35304a.a(createEntry).build();
            Intrinsics.checkNotNullExpressionValue(sliceBuild, "sliceBuilder.build()");
            return sliceBuild;
        }

        public final Slice.Builder a(CreateEntry createEntry) {
            Intrinsics.checkNotNullParameter(createEntry, "createEntry");
            CharSequence charSequenceB = createEntry.b();
            Icon iconE = createEntry.e();
            CharSequence charSequenceD = createEntry.d();
            Instant instantF = createEntry.f();
            Map map = createEntry.f35301f;
            PendingIntent pendingIntentG = createEntry.g();
            Slice.Builder builder = new Slice.Builder(Uri.EMPTY, new SliceSpec("CreateEntry", 1));
            String str = createEntry.h() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
            builder.addText(charSequenceB, null, CollectionsKt.listOf("androidx.credentials.provider.createEntry.SLICE_HINT_USER_PROVIDER_ACCOUNT_NAME"));
            if (instantF != null) {
                builder.addLong(instantF.toEpochMilli(), null, CollectionsKt.listOf("androidx.credentials.provider.createEntry.SLICE_HINT_LAST_USED_TIME_MILLIS"));
            }
            if (charSequenceD != null) {
                builder.addText(charSequenceD, null, CollectionsKt.listOf("androidx.credentials.provider.createEntry.SLICE_HINT_NOTE"));
            }
            if (iconE != null) {
                builder.addIcon(iconE, null, CollectionsKt.listOf("androidx.credentials.provider.createEntry.SLICE_HINT_PROFILE_ICON"));
            }
            Companion companion = CreateEntry.f35295i;
            if (companion.b(map) != null) {
                builder.addBundle(companion.b(map), null, CollectionsKt.listOf("androidx.credentials.provider.createEntry.SLICE_HINT_CREDENTIAL_COUNT_INFORMATION"));
            }
            builder.addAction(pendingIntentG, new Slice.Builder(builder).addHints(Collections.singletonList("androidx.credentials.provider.createEntry.SLICE_HINT_PENDING_INTENT")).build(), null).addText(str, null, CollectionsKt.listOf("androidx.credentials.provider.createEntry.SLICE_HINT_AUTO_SELECT_ALLOWED"));
            return builder;
        }

        public static final CreateEntry b(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<SliceItem> items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "slice.items");
            Map mapD = linkedHashMap;
            CharSequence text = null;
            PendingIntent action = null;
            Icon icon = null;
            CharSequence text2 = null;
            Instant instantOfEpochMilli = null;
            boolean z2 = false;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint("androidx.credentials.provider.createEntry.SLICE_HINT_USER_PROVIDER_ACCOUNT_NAME")) {
                    text = sliceItem.getText();
                } else if (sliceItem.hasHint("androidx.credentials.provider.createEntry.SLICE_HINT_PROFILE_ICON")) {
                    icon = sliceItem.getIcon();
                } else if (sliceItem.hasHint("androidx.credentials.provider.createEntry.SLICE_HINT_PENDING_INTENT")) {
                    action = sliceItem.getAction();
                } else if (sliceItem.hasHint("androidx.credentials.provider.createEntry.SLICE_HINT_CREDENTIAL_COUNT_INFORMATION")) {
                    Map mapA = CreateEntry.f35295i.a(sliceItem.getBundle());
                    Intrinsics.checkNotNull(mapA, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Int?>");
                    mapD = TypeIntrinsics.d(mapA);
                } else {
                    String str = MrGIhy.RfHSlFrTACAr;
                    if (sliceItem.hasHint(str)) {
                        instantOfEpochMilli = Instant.ofEpochMilli(sliceItem.getLong());
                    } else if (sliceItem.hasHint("androidx.credentials.provider.createEntry.SLICE_HINT_NOTE")) {
                        text2 = sliceItem.getText();
                    } else if (sliceItem.hasHint(str)) {
                        instantOfEpochMilli = Instant.ofEpochMilli(sliceItem.getLong());
                    } else if (sliceItem.hasHint("androidx.credentials.provider.createEntry.SLICE_HINT_AUTO_SELECT_ALLOWED") && Intrinsics.areEqual(sliceItem.getText(), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        z2 = true;
                    }
                }
            }
            try {
                Intrinsics.checkNotNull(text);
                Intrinsics.checkNotNull(action);
                return new CreateEntry(text, action, icon, text2, instantOfEpochMilli, mapD, z2, null, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, null);
            } catch (Exception e3) {
                Log.i("CreateEntry", "fromSlice failed with: " + e3.getMessage());
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api34Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api34Impl f35305a = new Api34Impl();

        private Api34Impl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api35Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api35Impl f35306a = new Api35Impl();

        private Api35Impl() {
        }

        private final void a(CreateEntry createEntry, Slice.Builder builder) {
            BiometricPromptData biometricPromptDataC = createEntry.c();
            if (biometricPromptDataC != null) {
                builder.addInt(biometricPromptDataC.a(), null, CollectionsKt.listOf("androidx.credentials.provider.createEntry.SLICE_HINT_ALLOWED_AUTHENTICATORS"));
                if (biometricPromptDataC.b() != null) {
                    builder.addLong(CryptoObjectUtils.f35401a.a(biometricPromptDataC.b()), null, CollectionsKt.listOf("androidx.credentials.provider.createEntry.SLICE_HINT_CRYPTO_OP_ID"));
                }
                builder.addBundle(BiometricPromptData.f35279d.d(biometricPromptDataC), null, CollectionsKt.listOf("androidx.credentials.provider.createEntry.SLICE_HINT_BIOMETRIC_PROMPT_DATA"));
            }
        }

        public static final CreateEntry b(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            CreateEntry createEntryB = Api28Impl.b(slice);
            if (createEntryB == null) {
                return null;
            }
            List<SliceItem> items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "slice.items");
            Bundle bundle = null;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_BIOMETRIC_PROMPT_DATA")) {
                    bundle = sliceItem.getBundle();
                }
            }
            try {
                return new CreateEntry(createEntryB.b(), createEntryB.g(), createEntryB.e(), createEntryB.d(), createEntryB.f(), createEntryB.f35301f, createEntryB.h(), bundle != null ? BiometricPromptData.f35279d.b(bundle) : null);
            } catch (Exception e3) {
                Log.i("CreateEntry", "fromSlice failed with: " + e3.getMessage());
                return null;
            }
        }

        public static final Slice c(CreateEntry createEntry) {
            Intrinsics.checkNotNullParameter(createEntry, "createEntry");
            Slice.Builder builderA = Api28Impl.f35304a.a(createEntry);
            f35306a.a(createEntry, builderA);
            Slice sliceBuild = builderA.build();
            Intrinsics.checkNotNullExpressionValue(sliceBuild, "sliceBuilder.build()");
            return sliceBuild;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map a(Bundle bundle) {
            HashMap map = new HashMap();
            if (bundle != null) {
                Set<String> setKeySet = bundle.keySet();
                Intrinsics.checkNotNullExpressionValue(setKeySet, "bundle.keySet()");
                for (String it : setKeySet) {
                    try {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        map.put(it, Integer.valueOf(bundle.getInt(it)));
                    } catch (Exception e3) {
                        Log.i("CreateEntry", "Issue unpacking credential count info bundle: " + e3.getMessage());
                    }
                }
            }
            return map;
        }

        public final Bundle b(Map credentialCountInformationMap) {
            Intrinsics.checkNotNullParameter(credentialCountInformationMap, "credentialCountInformationMap");
            Bundle bundle = new Bundle();
            boolean z2 = false;
            for (Map.Entry entry : credentialCountInformationMap.entrySet()) {
                if (entry.getValue() != null) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    Intrinsics.checkNotNull(value);
                    bundle.putInt(str, ((Number) value).intValue());
                    z2 = true;
                }
            }
            if (z2) {
                return bundle;
            }
            return null;
        }

        public final CreateEntry c(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            return Build.VERSION.SDK_INT >= 35 ? Api35Impl.b(slice) : Api28Impl.b(slice);
        }

        public final Slice d(CreateEntry createEntry) {
            Intrinsics.checkNotNullParameter(createEntry, "createEntry");
            return Build.VERSION.SDK_INT >= 35 ? Api35Impl.c(createEntry) : Api28Impl.c(createEntry);
        }

        private Companion() {
        }
    }

    public CreateEntry(CharSequence accountName, PendingIntent pendingIntent, Icon icon, CharSequence charSequence, Instant instant, Map credentialCountInformationMap, boolean z2, BiometricPromptData biometricPromptData) {
        Intrinsics.checkNotNullParameter(accountName, "accountName");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        Intrinsics.checkNotNullParameter(credentialCountInformationMap, "credentialCountInformationMap");
        this.f35296a = accountName;
        this.f35297b = pendingIntent;
        this.f35298c = icon;
        this.f35299d = charSequence;
        this.f35300e = instant;
        this.f35301f = credentialCountInformationMap;
        this.f35302g = z2;
        this.f35303h = biometricPromptData;
        if (accountName.length() <= 0) {
            throw new IllegalArgumentException("accountName must not be empty");
        }
        if (charSequence != null && charSequence.length() > 300) {
            throw new IllegalArgumentException("Description must follow a limit of 300 characters.");
        }
    }

    public final CharSequence b() {
        return this.f35296a;
    }

    public final BiometricPromptData c() {
        return this.f35303h;
    }

    public final CharSequence d() {
        return this.f35299d;
    }

    public final Icon e() {
        return this.f35298c;
    }

    public final Instant f() {
        return this.f35300e;
    }

    public final PendingIntent g() {
        return this.f35297b;
    }

    public final boolean h() {
        return this.f35302g;
    }

    public /* synthetic */ CreateEntry(CharSequence charSequence, PendingIntent pendingIntent, Icon icon, CharSequence charSequence2, Instant instant, Map map, boolean z2, BiometricPromptData biometricPromptData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, pendingIntent, icon, charSequence2, instant, map, z2, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : biometricPromptData);
    }
}
