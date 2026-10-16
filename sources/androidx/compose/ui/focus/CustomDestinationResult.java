package androidx.compose.ui.focus;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
public final class CustomDestinationResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CustomDestinationResult f25435a = new CustomDestinationResult("None", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CustomDestinationResult f25436b = new CustomDestinationResult(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED, 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CustomDestinationResult f25437c = new CustomDestinationResult("Redirected", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CustomDestinationResult f25438d = new CustomDestinationResult("RedirectCancelled", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ CustomDestinationResult[] f25439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f25440g;

    static {
        CustomDestinationResult[] customDestinationResultArrA = a();
        f25439f = customDestinationResultArrA;
        f25440g = EnumEntriesKt.a(customDestinationResultArrA);
    }

    private CustomDestinationResult(String str, int i3) {
    }

    private static final /* synthetic */ CustomDestinationResult[] a() {
        return new CustomDestinationResult[]{f25435a, f25436b, f25437c, f25438d};
    }

    public static CustomDestinationResult valueOf(String str) {
        return (CustomDestinationResult) Enum.valueOf(CustomDestinationResult.class, str);
    }

    public static CustomDestinationResult[] values() {
        return (CustomDestinationResult[]) f25439f.clone();
    }
}
