package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class JsonTreeReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractJsonLexer f143126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f143127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f143128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f143129d;

    public JsonTreeReader(JsonConfiguration configuration, AbstractJsonLexer lexer) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        this.f143126a = lexer;
        this.f143127b = configuration.q();
        this.f143128c = configuration.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonElement f() {
        byte bJ = this.f143126a.j();
        if (this.f143126a.H() == 4) {
            AbstractJsonLexer.x(this.f143126a, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        ArrayList arrayList = new ArrayList();
        while (this.f143126a.e()) {
            arrayList.add(e());
            bJ = this.f143126a.j();
            if (bJ != 4) {
                AbstractJsonLexer abstractJsonLexer = this.f143126a;
                boolean z2 = bJ == 9;
                int i3 = abstractJsonLexer.f143035a;
                if (!z2) {
                    AbstractJsonLexer.x(abstractJsonLexer, "Expected end of the array or comma", i3, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (bJ == 8) {
            this.f143126a.k((byte) 9);
        } else if (bJ == 4) {
            if (!this.f143128c) {
                JsonExceptionsKt.h(this.f143126a, "array");
                throw new KotlinNothingValueException();
            }
            this.f143126a.k((byte) 9);
        }
        return new JsonArray(arrayList);
    }

    private final JsonElement g() {
        return (JsonElement) DeepRecursiveKt.b(new DeepRecursiveFunction(new JsonTreeReader$readDeepRecursive$1(this, null)), Unit.f139807a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0096 -> B:27:0x00a0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(kotlin.DeepRecursiveScope r20, kotlin.coroutines.Continuation r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonTreeReader.h(kotlin.DeepRecursiveScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final JsonElement i() {
        byte bK = this.f143126a.k((byte) 6);
        if (this.f143126a.H() == 4) {
            AbstractJsonLexer.x(this.f143126a, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            if (!this.f143126a.e()) {
                break;
            }
            String strQ = this.f143127b ? this.f143126a.q() : this.f143126a.o();
            this.f143126a.k((byte) 5);
            linkedHashMap.put(strQ, e());
            bK = this.f143126a.j();
            if (bK != 4) {
                if (bK != 7) {
                    AbstractJsonLexer.x(this.f143126a, "Expected end of the object or comma", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (bK == 6) {
            this.f143126a.k((byte) 7);
        } else if (bK == 4) {
            if (!this.f143128c) {
                JsonExceptionsKt.i(this.f143126a, null, 1, null);
                throw new KotlinNothingValueException();
            }
            this.f143126a.k((byte) 7);
        }
        return new JsonObject(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonPrimitive j(boolean z2) {
        String strQ = (this.f143127b || !z2) ? this.f143126a.q() : this.f143126a.o();
        return (z2 || !Intrinsics.areEqual(strQ, "null")) ? new JsonLiteral(strQ, z2, null, 4, null) : JsonNull.INSTANCE;
    }

    public final JsonElement e() {
        byte bH = this.f143126a.H();
        if (bH == 1) {
            return j(true);
        }
        if (bH == 0) {
            return j(false);
        }
        if (bH == 6) {
            int i3 = this.f143129d + 1;
            this.f143129d = i3;
            this.f143129d--;
            return i3 == 200 ? g() : i();
        }
        if (bH == 8) {
            return f();
        }
        AbstractJsonLexer.x(this.f143126a, "Cannot read Json element because of unexpected " + AbstractJsonLexerKt.c(bH), 0, null, 6, null);
        throw new KotlinNothingValueException();
    }
}
