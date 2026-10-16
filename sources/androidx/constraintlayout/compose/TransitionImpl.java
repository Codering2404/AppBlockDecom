package androidx.constraintlayout.compose;

import android.util.Log;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.TransitionParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class TransitionImpl implements Transition {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f30993b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final TransitionImpl f30994c = new TransitionImpl(new CLObject(new char[0]));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CLObject f30995a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransitionImpl a() {
            return TransitionImpl.f30994c;
        }

        private Companion() {
        }
    }

    public TransitionImpl(CLObject cLObject) {
        this.f30995a = cLObject;
    }

    @Override // androidx.constraintlayout.compose.Transition
    public String a() {
        String strS = this.f30995a.S("from");
        return strS == null ? "start" : strS;
    }

    @Override // androidx.constraintlayout.compose.Transition
    public String b() {
        String strS = this.f30995a.S("to");
        return strS == null ? "end" : strS;
    }

    public final void d(androidx.constraintlayout.core.state.Transition transition) {
        try {
            TransitionParser.c(this.f30995a, transition);
        } catch (CLParsingException e3) {
            Log.e("CML", "Error parsing JSON " + e3);
        }
    }

    public final void e(androidx.constraintlayout.core.state.Transition transition) {
        try {
            TransitionParser.f(this.f30995a, transition);
        } catch (CLParsingException e3) {
            Log.e("CML", "Error parsing JSON " + e3);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(TransitionImpl.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.constraintlayout.compose.TransitionImpl");
        return Intrinsics.areEqual(this.f30995a, ((TransitionImpl) obj).f30995a);
    }

    public int hashCode() {
        return this.f30995a.hashCode();
    }
}
