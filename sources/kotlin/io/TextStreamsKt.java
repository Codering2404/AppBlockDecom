package kotlin.io;

import com.facebook.internal.Utility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

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
public final class TextStreamsKt {
    public static final long b(Reader reader, Writer out, int i3) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        char[] cArr = new char[i3];
        int i4 = reader.read(cArr);
        long j3 = 0;
        while (i4 >= 0) {
            out.write(cArr, 0, i4);
            j3 += (long) i4;
            i4 = reader.read(cArr);
        }
        return j3;
    }

    public static /* synthetic */ long c(Reader reader, Writer writer, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        return b(reader, writer, i3);
    }

    public static final void d(Reader reader, Function1 action) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        try {
            Iterator it = e(bufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            Unit unit = Unit.f139807a;
            CloseableKt.a(bufferedReader, null);
        } finally {
        }
    }

    public static final Sequence e(BufferedReader bufferedReader) {
        Intrinsics.checkNotNullParameter(bufferedReader, "<this>");
        return SequencesKt.f(new LinesSequence(bufferedReader));
    }

    public static final List f(Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        final ArrayList arrayList = new ArrayList();
        d(reader, new Function1() { // from class: kotlin.io.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextStreamsKt.g(arrayList, (String) obj);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(ArrayList arrayList, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        arrayList.add(it);
        return Unit.f139807a;
    }

    public static final String h(Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        c(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
