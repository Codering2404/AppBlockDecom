package com.applovin.impl.mediation;

import com.applovin.mediation.MaxSegment;
import com.applovin.mediation.MaxSegmentCollection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxSegmentCollectionImpl implements MaxSegmentCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f61445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f61446b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class BuilderImpl implements MaxSegmentCollection.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f61447a = new ArrayList();

        @Override // com.applovin.mediation.MaxSegmentCollection.Builder
        public MaxSegmentCollection.Builder addSegment(MaxSegment maxSegment) {
            this.f61447a.add(maxSegment);
            return this;
        }

        @Override // com.applovin.mediation.MaxSegmentCollection.Builder
        public MaxSegmentCollection build() {
            return new MaxSegmentCollectionImpl(this);
        }
    }

    public Map<String, List<Integer>> getJsonData() {
        return this.f61446b;
    }

    @Override // com.applovin.mediation.MaxSegmentCollection
    public List<MaxSegment> getSegments() {
        return this.f61445a;
    }

    public String toString() {
        return "MaxSegmentColletionImpl{segments=" + this.f61445a + "}";
    }

    private MaxSegmentCollectionImpl(BuilderImpl builderImpl) {
        List<MaxSegment> list = builderImpl.f61447a;
        this.f61445a = list;
        this.f61446b = new HashMap();
        for (MaxSegment maxSegment : list) {
            this.f61446b.put("segment_" + maxSegment.getKey(), maxSegment.getValues());
        }
    }
}
