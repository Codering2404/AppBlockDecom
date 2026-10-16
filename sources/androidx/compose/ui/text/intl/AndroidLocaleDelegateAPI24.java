package androidx.compose.ui.text.intl;

import android.util.Log;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AndroidLocaleDelegateAPI24 implements PlatformLocaleDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.os.LocaleList f29465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LocaleList f29466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SynchronizedObject f29467c = new SynchronizedObject();

    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    public java.util.Locale a(String str) {
        java.util.Locale localeForLanguageTag = java.util.Locale.forLanguageTag(str);
        if (Intrinsics.areEqual(localeForLanguageTag.toLanguageTag(), "und")) {
            Log.e(AndroidLocaleDelegate_androidKt.f29468a, "The language tag " + str + " is not well-formed. Locale is resolved to Undetermined. Note that underscore '_' is not a valid subtag delimiter and must be replaced with '-'.");
        }
        return localeForLanguageTag;
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    public LocaleList b() {
        android.os.LocaleList localeList = android.os.LocaleList.getDefault();
        synchronized (this.f29467c) {
            LocaleList localeList2 = this.f29466b;
            if (localeList2 != null && localeList == this.f29465a) {
                return localeList2;
            }
            int size = localeList.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(new Locale(localeList.get(i3)));
            }
            LocaleList localeList3 = new LocaleList(arrayList);
            this.f29465a = localeList;
            this.f29466b = localeList3;
            return localeList3;
        }
    }
}
