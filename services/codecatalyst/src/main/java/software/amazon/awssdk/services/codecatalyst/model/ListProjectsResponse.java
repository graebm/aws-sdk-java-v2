/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package software.amazon.awssdk.services.codecatalyst.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.core.SdkField;
import software.amazon.awssdk.core.SdkPojo;
import software.amazon.awssdk.core.protocol.MarshallLocation;
import software.amazon.awssdk.core.protocol.MarshallingType;
import software.amazon.awssdk.core.traits.ListTrait;
import software.amazon.awssdk.core.traits.LocationTrait;
import software.amazon.awssdk.core.util.DefaultSdkAutoConstructList;
import software.amazon.awssdk.core.util.SdkAutoConstructList;
import software.amazon.awssdk.utils.ToString;
import software.amazon.awssdk.utils.builder.CopyableBuilder;
import software.amazon.awssdk.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("software.amazon.awssdk:codegen")
public final class ListProjectsResponse extends CodeCatalystResponse implements
        ToCopyableBuilder<ListProjectsResponse.Builder, ListProjectsResponse> {
    private static final SdkField<String> NEXT_TOKEN_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("nextToken").getter(getter(ListProjectsResponse::nextToken)).setter(setter(Builder::nextToken))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("nextToken").build()).build();

    private static final SdkField<List<ProjectSummary>> ITEMS_FIELD = SdkField
            .<List<ProjectSummary>> builder(MarshallingType.LIST)
            .memberName("items")
            .getter(getter(ListProjectsResponse::items))
            .setter(setter(Builder::items))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("items").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<ProjectSummary> builder(MarshallingType.SDK_POJO)
                                            .constructor(ProjectSummary::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections
            .unmodifiableList(Arrays.asList(NEXT_TOKEN_FIELD, ITEMS_FIELD));

    private final String nextToken;

    private final List<ProjectSummary> items;

    private ListProjectsResponse(BuilderImpl builder) {
        super(builder);
        this.nextToken = builder.nextToken;
        this.items = builder.items;
    }

    /**
     * <p>
     * A token returned from a call to this API to indicate the next batch of results to return, if any.
     * </p>
     * 
     * @return A token returned from a call to this API to indicate the next batch of results to return, if any.
     */
    public final String nextToken() {
        return nextToken;
    }

    /**
     * For responses, this returns true if the service returned a value for the Items property. This DOES NOT check that
     * the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is useful
     * because the SDK will never return a null collection or map, but you may need to differentiate between the service
     * returning nothing (or null) and the service returning an empty collection or map. For requests, this returns true
     * if a value for the property was specified in the request builder, and false if a value was not specified.
     */
    public final boolean hasItems() {
        return items != null && !(items instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * Information about the projects.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasItems} method.
     * </p>
     * 
     * @return Information about the projects.
     */
    public final List<ProjectSummary> items() {
        return items;
    }

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public static Class<? extends Builder> serializableBuilderClass() {
        return BuilderImpl.class;
    }

    @Override
    public final int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + super.hashCode();
        hashCode = 31 * hashCode + Objects.hashCode(nextToken());
        hashCode = 31 * hashCode + Objects.hashCode(hasItems() ? items() : null);
        return hashCode;
    }

    @Override
    public final boolean equals(Object obj) {
        return super.equals(obj) && equalsBySdkFields(obj);
    }

    @Override
    public final boolean equalsBySdkFields(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ListProjectsResponse)) {
            return false;
        }
        ListProjectsResponse other = (ListProjectsResponse) obj;
        return Objects.equals(nextToken(), other.nextToken()) && hasItems() == other.hasItems()
                && Objects.equals(items(), other.items());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ListProjectsResponse").add("NextToken", nextToken()).add("Items", hasItems() ? items() : null)
                .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "nextToken":
            return Optional.ofNullable(clazz.cast(nextToken()));
        case "items":
            return Optional.ofNullable(clazz.cast(items()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<ListProjectsResponse, T> g) {
        return obj -> g.apply((ListProjectsResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends CodeCatalystResponse.Builder, SdkPojo, CopyableBuilder<Builder, ListProjectsResponse> {
        /**
         * <p>
         * A token returned from a call to this API to indicate the next batch of results to return, if any.
         * </p>
         * 
         * @param nextToken
         *        A token returned from a call to this API to indicate the next batch of results to return, if any.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder nextToken(String nextToken);

        /**
         * <p>
         * Information about the projects.
         * </p>
         * 
         * @param items
         *        Information about the projects.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder items(Collection<ProjectSummary> items);

        /**
         * <p>
         * Information about the projects.
         * </p>
         * 
         * @param items
         *        Information about the projects.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder items(ProjectSummary... items);

        /**
         * <p>
         * Information about the projects.
         * </p>
         * This is a convenience method that creates an instance of the
         * {@link software.amazon.awssdk.services.codecatalyst.model.ProjectSummary.Builder} avoiding the need to create
         * one manually via {@link software.amazon.awssdk.services.codecatalyst.model.ProjectSummary#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes,
         * {@link software.amazon.awssdk.services.codecatalyst.model.ProjectSummary.Builder#build()} is called
         * immediately and its result is passed to {@link #items(List<ProjectSummary>)}.
         * 
         * @param items
         *        a consumer that will call methods on
         *        {@link software.amazon.awssdk.services.codecatalyst.model.ProjectSummary.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #items(java.util.Collection<ProjectSummary>)
         */
        Builder items(Consumer<ProjectSummary.Builder>... items);
    }

    static final class BuilderImpl extends CodeCatalystResponse.BuilderImpl implements Builder {
        private String nextToken;

        private List<ProjectSummary> items = DefaultSdkAutoConstructList.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(ListProjectsResponse model) {
            super(model);
            nextToken(model.nextToken);
            items(model.items);
        }

        public final String getNextToken() {
            return nextToken;
        }

        public final void setNextToken(String nextToken) {
            this.nextToken = nextToken;
        }

        @Override
        public final Builder nextToken(String nextToken) {
            this.nextToken = nextToken;
            return this;
        }

        public final List<ProjectSummary.Builder> getItems() {
            List<ProjectSummary.Builder> result = ProjectSummariesCopier.copyToBuilder(this.items);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setItems(Collection<ProjectSummary.BuilderImpl> items) {
            this.items = ProjectSummariesCopier.copyFromBuilder(items);
        }

        @Override
        public final Builder items(Collection<ProjectSummary> items) {
            this.items = ProjectSummariesCopier.copy(items);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder items(ProjectSummary... items) {
            items(Arrays.asList(items));
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder items(Consumer<ProjectSummary.Builder>... items) {
            items(Stream.of(items).map(c -> ProjectSummary.builder().applyMutation(c).build()).collect(Collectors.toList()));
            return this;
        }

        @Override
        public ListProjectsResponse build() {
            return new ListProjectsResponse(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}