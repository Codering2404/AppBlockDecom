package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextMotion;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class Savers_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Saver f28846a = SaverKt.a(new Function2<SaverScope, PlatformParagraphStyle, Object>() { // from class: androidx.compose.ui.text.Savers_androidKt$PlatformParagraphStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, PlatformParagraphStyle platformParagraphStyle) {
            return CollectionsKt.arrayListOf(SaversKt.y(Boolean.valueOf(platformParagraphStyle.c())), SaversKt.y(EmojiSupportMatch.d(platformParagraphStyle.b())));
        }
    }, new Function1<Object, PlatformParagraphStyle>() { // from class: androidx.compose.ui.text.Savers_androidKt$PlatformParagraphStyleSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final PlatformParagraphStyle invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Boolean bool = obj2 != null ? (Boolean) obj2 : null;
            Intrinsics.checkNotNull(bool);
            boolean zBooleanValue = bool.booleanValue();
            Object obj3 = list.get(1);
            EmojiSupportMatch emojiSupportMatch = obj3 != null ? (EmojiSupportMatch) obj3 : null;
            Intrinsics.checkNotNull(emojiSupportMatch);
            return new PlatformParagraphStyle(emojiSupportMatch.j(), zBooleanValue, null);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Saver f28847b = SaverKt.a(new Function2<SaverScope, LineBreak, Object>() { // from class: androidx.compose.ui.text.Savers_androidKt$LineBreakSaver$1
        public final Object c(SaverScope saverScope, int i3) {
            return Integer.valueOf(i3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return c((SaverScope) obj, ((LineBreak) obj2).l());
        }
    }, new Function1<Object, LineBreak>() { // from class: androidx.compose.ui.text.Savers_androidKt$LineBreakSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final LineBreak invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            return LineBreak.c(LineBreak.d(((Integer) obj).intValue()));
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Saver f28848c = SaverKt.a(new Function2<SaverScope, TextMotion, Object>() { // from class: androidx.compose.ui.text.Savers_androidKt$TextMotionSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, TextMotion textMotion) {
            return CollectionsKt.arrayListOf(SaversKt.y(TextMotion.Linearity.d(textMotion.b())), SaversKt.y(Boolean.valueOf(textMotion.c())));
        }
    }, new Function1<Object, TextMotion>() { // from class: androidx.compose.ui.text.Savers_androidKt$TextMotionSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final TextMotion invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            TextMotion.Linearity linearity = obj2 != null ? (TextMotion.Linearity) obj2 : null;
            Intrinsics.checkNotNull(linearity);
            int iJ = linearity.j();
            Object obj3 = list.get(1);
            Boolean bool = obj3 != null ? (Boolean) obj3 : null;
            Intrinsics.checkNotNull(bool);
            return new TextMotion(iJ, bool.booleanValue(), null);
        }
    });

    public static final Saver a(PlatformParagraphStyle.Companion companion) {
        return f28846a;
    }

    public static final Saver b(LineBreak.Companion companion) {
        return f28847b;
    }

    public static final Saver c(TextMotion.Companion companion) {
        return f28848c;
    }
}
