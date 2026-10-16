package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MergePathsContent implements PathContent, GreedyContent {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f56516d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MergePaths f56518f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f56513a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f56514b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f56515c = new Path();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f56517e = new ArrayList();

    /* JADX INFO: renamed from: com.airbnb.lottie.animation.content.MergePathsContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f56519a;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            f56519a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f56519a[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f56519a[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f56519a[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f56519a[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public MergePathsContent(MergePaths mergePaths) {
        this.f56516d = mergePaths.c();
        this.f56518f = mergePaths;
    }

    private void a() {
        for (int i3 = 0; i3 < this.f56517e.size(); i3++) {
            this.f56515c.addPath(((PathContent) this.f56517e.get(i3)).g());
        }
    }

    private void d(Path.Op op) {
        this.f56514b.reset();
        this.f56513a.reset();
        for (int size = this.f56517e.size() - 1; size >= 1; size--) {
            PathContent pathContent = (PathContent) this.f56517e.get(size);
            if (pathContent instanceof ContentGroup) {
                ContentGroup contentGroup = (ContentGroup) pathContent;
                List listL = contentGroup.l();
                for (int size2 = listL.size() - 1; size2 >= 0; size2--) {
                    Path pathG = ((PathContent) listL.get(size2)).g();
                    pathG.transform(contentGroup.m());
                    this.f56514b.addPath(pathG);
                }
            } else {
                this.f56514b.addPath(pathContent.g());
            }
        }
        PathContent pathContent2 = (PathContent) this.f56517e.get(0);
        if (pathContent2 instanceof ContentGroup) {
            ContentGroup contentGroup2 = (ContentGroup) pathContent2;
            List listL2 = contentGroup2.l();
            for (int i3 = 0; i3 < listL2.size(); i3++) {
                Path pathG2 = ((PathContent) listL2.get(i3)).g();
                pathG2.transform(contentGroup2.m());
                this.f56513a.addPath(pathG2);
            }
        } else {
            this.f56513a.set(pathContent2.g());
        }
        this.f56515c.op(this.f56513a, this.f56514b, op);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List list, List list2) {
        for (int i3 = 0; i3 < this.f56517e.size(); i3++) {
            ((PathContent) this.f56517e.get(i3)).b(list, list2);
        }
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path g() {
        this.f56515c.reset();
        if (this.f56518f.d()) {
            return this.f56515c;
        }
        int i3 = AnonymousClass1.f56519a[this.f56518f.b().ordinal()];
        if (i3 == 1) {
            a();
        } else if (i3 == 2) {
            d(Path.Op.UNION);
        } else if (i3 == 3) {
            d(Path.Op.REVERSE_DIFFERENCE);
        } else if (i3 == 4) {
            d(Path.Op.INTERSECT);
        } else if (i3 == 5) {
            d(Path.Op.XOR);
        }
        return this.f56515c;
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public void h(ListIterator listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content content = (Content) listIterator.previous();
            if (content instanceof PathContent) {
                this.f56517e.add((PathContent) content);
                listIterator.remove();
            }
        }
    }
}
