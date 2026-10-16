package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ActivityComponentInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class MatcherUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MatcherUtils f54221a = new MatcherUtils();

    private MatcherUtils() {
    }

    private final boolean d(String str, String str2) {
        if (!StringsKt.a0(str2, "*", false, 2, null)) {
            return false;
        }
        if (Intrinsics.areEqual(str2, "*")) {
            return true;
        }
        if (StringsKt.n0(str2, "*", 0, false, 6, null) != StringsKt.u0(str2, "*", 0, false, 6, null) || !StringsKt.E(str2, "*", false, 2, null)) {
            throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end");
        }
        String strSubstring = str2.substring(0, str2.length() - 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return StringsKt.U(str, strSubstring, false, 2, null);
    }

    public final boolean a(ActivityComponentInfo activityComponentInfo, ActivityComponentInfo ruleComponent) {
        Intrinsics.checkNotNullParameter(ruleComponent, "ruleComponent");
        if (activityComponentInfo == null) {
            return Intrinsics.areEqual(ruleComponent.b(), "*") && Intrinsics.areEqual(ruleComponent.a(), "*");
        }
        if (StringsKt.a0(activityComponentInfo.toString(), "*", false, 2, null)) {
            throw new IllegalArgumentException("Wildcard can only be part of the rule.");
        }
        return (Intrinsics.areEqual(activityComponentInfo.b(), ruleComponent.b()) || d(activityComponentInfo.b(), ruleComponent.b())) && (Intrinsics.areEqual(activityComponentInfo.a(), ruleComponent.a()) || d(activityComponentInfo.a(), ruleComponent.a()));
    }

    public final boolean b(Activity activity, ActivityComponentInfo ruleComponent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(ruleComponent, "ruleComponent");
        ComponentName componentName = activity.getComponentName();
        Intrinsics.checkNotNullExpressionValue(componentName, "activity.componentName");
        if (a(new ActivityComponentInfo(componentName), ruleComponent)) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent != null) {
            return f54221a.c(intent, ruleComponent);
        }
        return false;
    }

    public final boolean c(Intent intent, ActivityComponentInfo ruleComponent) {
        String str;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(ruleComponent, "ruleComponent");
        ComponentName component = intent.getComponent();
        if (a(component != null ? new ActivityComponentInfo(component) : null, ruleComponent)) {
            return true;
        }
        if (intent.getComponent() == null && (str = intent.getPackage()) != null) {
            return (Intrinsics.areEqual(str, ruleComponent.b()) || d(str, ruleComponent.b())) && Intrinsics.areEqual(ruleComponent.a(), "*");
        }
        return false;
    }
}
