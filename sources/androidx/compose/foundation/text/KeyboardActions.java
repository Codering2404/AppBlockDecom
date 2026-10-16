package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class KeyboardActions {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f9756g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final KeyboardActions f9757h = new KeyboardActions(null, null, null, null, null, null, 63, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f9758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f9759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f9760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f9761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function1 f9762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Function1 f9763f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KeyboardActions a() {
            return KeyboardActions.f9757h;
        }

        private Companion() {
        }
    }

    public KeyboardActions(Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16) {
        this.f9758a = function1;
        this.f9759b = function12;
        this.f9760c = function13;
        this.f9761d = function14;
        this.f9762e = function15;
        this.f9763f = function16;
    }

    public final Function1 b() {
        return this.f9758a;
    }

    public final Function1 c() {
        return this.f9759b;
    }

    public final Function1 d() {
        return this.f9760c;
    }

    public final Function1 e() {
        return this.f9761d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardActions)) {
            return false;
        }
        KeyboardActions keyboardActions = (KeyboardActions) obj;
        return this.f9758a == keyboardActions.f9758a && this.f9759b == keyboardActions.f9759b && this.f9760c == keyboardActions.f9760c && this.f9761d == keyboardActions.f9761d && this.f9762e == keyboardActions.f9762e && this.f9763f == keyboardActions.f9763f;
    }

    public final Function1 f() {
        return this.f9762e;
    }

    public final Function1 g() {
        return this.f9763f;
    }

    public int hashCode() {
        Function1 function1 = this.f9758a;
        int iHashCode = (function1 != null ? function1.hashCode() : 0) * 31;
        Function1 function12 = this.f9759b;
        int iHashCode2 = (iHashCode + (function12 != null ? function12.hashCode() : 0)) * 31;
        Function1 function13 = this.f9760c;
        int iHashCode3 = (iHashCode2 + (function13 != null ? function13.hashCode() : 0)) * 31;
        Function1 function14 = this.f9761d;
        int iHashCode4 = (iHashCode3 + (function14 != null ? function14.hashCode() : 0)) * 31;
        Function1 function15 = this.f9762e;
        int iHashCode5 = (iHashCode4 + (function15 != null ? function15.hashCode() : 0)) * 31;
        Function1 function16 = this.f9763f;
        return iHashCode5 + (function16 != null ? function16.hashCode() : 0);
    }

    public /* synthetic */ KeyboardActions(Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : function1, (i3 & 2) != 0 ? null : function12, (i3 & 4) != 0 ? null : function13, (i3 & 8) != 0 ? null : function14, (i3 & 16) != 0 ? null : function15, (i3 & 32) != 0 ? null : function16);
    }
}
