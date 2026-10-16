package ru.noties.markwon;

import android.content.Context;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.commonmark.parser.Parser;
import ru.noties.markwon.Markwon;
import ru.noties.markwon.MarkwonConfiguration;
import ru.noties.markwon.MarkwonSpansFactoryImpl;
import ru.noties.markwon.MarkwonVisitorImpl;
import ru.noties.markwon.core.CorePlugin;
import ru.noties.markwon.core.MarkwonTheme;
import ru.noties.markwon.html.MarkwonHtmlRenderer;
import ru.noties.markwon.image.AsyncDrawableLoader;
import ru.noties.markwon.priority.PriorityProcessor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class MarkwonBuilderImpl implements Markwon.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f147057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f147058b = new ArrayList(3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView.BufferType f147059c = TextView.BufferType.SPANNABLE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PriorityProcessor f147060d;

    MarkwonBuilderImpl(Context context) {
        this.f147057a = context;
    }

    static List b(List list) {
        Iterator it = list.iterator();
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MarkwonPlugin markwonPlugin = (MarkwonPlugin) it.next();
            if (CorePlugin.class.isAssignableFrom(markwonPlugin.getClass())) {
                z2 = true;
                break;
            }
            if (!z3 && markwonPlugin.priority().a().contains(CorePlugin.class)) {
                z3 = true;
            }
        }
        if (!z3 || z2) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.size() + 1);
        arrayList.add(CorePlugin.f());
        arrayList.addAll(list);
        return arrayList;
    }

    static List c(PriorityProcessor priorityProcessor, List list) {
        return priorityProcessor.b(b(list));
    }

    @Override // ru.noties.markwon.Markwon.Builder
    public Markwon.Builder a(MarkwonPlugin markwonPlugin) {
        this.f147058b.add(markwonPlugin);
        return this;
    }

    @Override // ru.noties.markwon.Markwon.Builder
    public Markwon build() {
        if (this.f147058b.isEmpty()) {
            throw new IllegalStateException("No plugins were added to this builder. Use #usePlugin method to add them");
        }
        PriorityProcessor priorityProcessorA = this.f147060d;
        if (priorityProcessorA == null) {
            priorityProcessorA = PriorityProcessor.a();
            this.f147060d = priorityProcessorA;
        }
        List<MarkwonPlugin> listC = c(priorityProcessorA, this.f147058b);
        Parser.Builder builder = new Parser.Builder();
        MarkwonTheme.Builder builderJ = MarkwonTheme.j(this.f147057a);
        AsyncDrawableLoader.Builder builder2 = new AsyncDrawableLoader.Builder();
        MarkwonConfiguration.Builder builder3 = new MarkwonConfiguration.Builder();
        MarkwonVisitorImpl.BuilderImpl builderImpl = new MarkwonVisitorImpl.BuilderImpl();
        MarkwonSpansFactoryImpl.BuilderImpl builderImpl2 = new MarkwonSpansFactoryImpl.BuilderImpl();
        MarkwonHtmlRenderer.Builder builderA = MarkwonHtmlRenderer.a();
        for (MarkwonPlugin markwonPlugin : listC) {
            markwonPlugin.configureParser(builder);
            markwonPlugin.configureTheme(builderJ);
            markwonPlugin.configureImages(builder2);
            markwonPlugin.configureConfiguration(builder3);
            markwonPlugin.configureVisitor(builderImpl);
            markwonPlugin.configureSpansFactory(builderImpl2);
            markwonPlugin.configureHtmlRenderer(builderA);
        }
        return new MarkwonImpl(this.f147059c, builder.g(), builderImpl.a(builder3.j(builderJ.y(), builder2.c(), builderA.build(), builderImpl2.build()), new RenderPropsImpl()), Collections.unmodifiableList(listC));
    }
}
