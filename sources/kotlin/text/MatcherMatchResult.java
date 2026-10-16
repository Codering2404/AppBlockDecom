package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;

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
final class MatcherMatchResult implements MatchResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Matcher f140567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f140568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MatchGroupCollection f140569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List f140570d;

    public MatcherMatchResult(Matcher matcher, CharSequence input) {
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        Intrinsics.checkNotNullParameter(input, "input");
        this.f140567a = matcher;
        this.f140568b = input;
        this.f140569c = new MatcherMatchResult$groups$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.util.regex.MatchResult f() {
        return this.f140567a;
    }

    @Override // kotlin.text.MatchResult
    public /* bridge */ MatchResult.Destructured a() {
        return MatchResult.DefaultImpls.a(this);
    }

    @Override // kotlin.text.MatchResult
    public List b() {
        if (this.f140570d == null) {
            this.f140570d = new AbstractList<String>() { // from class: kotlin.text.MatcherMatchResult$groupValues$1
                public /* bridge */ boolean b(String str) {
                    return super.contains(str);
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
                public final /* bridge */ boolean contains(Object obj) {
                    if (obj instanceof String) {
                        return b((String) obj);
                    }
                    return false;
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public String get(int i3) {
                    String strGroup = this.f140571a.f().group(i3);
                    return strGroup == null ? "" : strGroup;
                }

                public /* bridge */ int e(String str) {
                    return super.indexOf(str);
                }

                public /* bridge */ int f(String str) {
                    return super.lastIndexOf(str);
                }

                @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
                public int getSize() {
                    return this.f140571a.f().groupCount() + 1;
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int indexOf(Object obj) {
                    if (obj instanceof String) {
                        return e((String) obj);
                    }
                    return -1;
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int lastIndexOf(Object obj) {
                    if (obj instanceof String) {
                        return f((String) obj);
                    }
                    return -1;
                }
            };
        }
        List list = this.f140570d;
        Intrinsics.checkNotNull(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    public IntRange c() {
        return RegexKt.g(f());
    }

    @Override // kotlin.text.MatchResult
    public MatchGroupCollection d() {
        return this.f140569c;
    }

    @Override // kotlin.text.MatchResult
    public String getValue() {
        String strGroup = f().group();
        Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
        return strGroup;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult next() {
        int iEnd = f().end() + (f().end() == f().start() ? 1 : 0);
        if (iEnd > this.f140568b.length()) {
            return null;
        }
        Matcher matcher = this.f140567a.pattern().matcher(this.f140568b);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        return RegexKt.e(matcher, iEnd, this.f140568b);
    }
}
