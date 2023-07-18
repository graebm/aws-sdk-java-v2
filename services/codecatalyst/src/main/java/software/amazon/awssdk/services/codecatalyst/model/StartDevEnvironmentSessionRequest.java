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
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.awscore.AwsRequestOverrideConfiguration;
import software.amazon.awssdk.core.SdkField;
import software.amazon.awssdk.core.SdkPojo;
import software.amazon.awssdk.core.protocol.MarshallLocation;
import software.amazon.awssdk.core.protocol.MarshallingType;
import software.amazon.awssdk.core.traits.LocationTrait;
import software.amazon.awssdk.utils.ToString;
import software.amazon.awssdk.utils.builder.CopyableBuilder;
import software.amazon.awssdk.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("software.amazon.awssdk:codegen")
public final class StartDevEnvironmentSessionRequest extends CodeCatalystRequest implements
        ToCopyableBuilder<StartDevEnvironmentSessionRequest.Builder, StartDevEnvironmentSessionRequest> {
    private static final SdkField<String> SPACE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("spaceName").getter(getter(StartDevEnvironmentSessionRequest::spaceName))
            .setter(setter(Builder::spaceName))
            .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("spaceName").build()).build();

    private static final SdkField<String> PROJECT_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("projectName").getter(getter(StartDevEnvironmentSessionRequest::projectName))
            .setter(setter(Builder::projectName))
            .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("projectName").build()).build();

    private static final SdkField<String> ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("id")
            .getter(getter(StartDevEnvironmentSessionRequest::id)).setter(setter(Builder::id))
            .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("id").build()).build();

    private static final SdkField<DevEnvironmentSessionConfiguration> SESSION_CONFIGURATION_FIELD = SdkField
            .<DevEnvironmentSessionConfiguration> builder(MarshallingType.SDK_POJO).memberName("sessionConfiguration")
            .getter(getter(StartDevEnvironmentSessionRequest::sessionConfiguration))
            .setter(setter(Builder::sessionConfiguration)).constructor(DevEnvironmentSessionConfiguration::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("sessionConfiguration").build())
            .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(SPACE_NAME_FIELD,
            PROJECT_NAME_FIELD, ID_FIELD, SESSION_CONFIGURATION_FIELD));

    private final String spaceName;

    private final String projectName;

    private final String id;

    private final DevEnvironmentSessionConfiguration sessionConfiguration;

    private StartDevEnvironmentSessionRequest(BuilderImpl builder) {
        super(builder);
        this.spaceName = builder.spaceName;
        this.projectName = builder.projectName;
        this.id = builder.id;
        this.sessionConfiguration = builder.sessionConfiguration;
    }

    /**
     * <p>
     * The name of the space.
     * </p>
     * 
     * @return The name of the space.
     */
    public final String spaceName() {
        return spaceName;
    }

    /**
     * <p>
     * The name of the project in the space.
     * </p>
     * 
     * @return The name of the project in the space.
     */
    public final String projectName() {
        return projectName;
    }

    /**
     * <p>
     * The system-generated unique ID of the Dev Environment.
     * </p>
     * 
     * @return The system-generated unique ID of the Dev Environment.
     */
    public final String id() {
        return id;
    }

    /**
     * Returns the value of the SessionConfiguration property for this object.
     * 
     * @return The value of the SessionConfiguration property for this object.
     */
    public final DevEnvironmentSessionConfiguration sessionConfiguration() {
        return sessionConfiguration;
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
        hashCode = 31 * hashCode + Objects.hashCode(spaceName());
        hashCode = 31 * hashCode + Objects.hashCode(projectName());
        hashCode = 31 * hashCode + Objects.hashCode(id());
        hashCode = 31 * hashCode + Objects.hashCode(sessionConfiguration());
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
        if (!(obj instanceof StartDevEnvironmentSessionRequest)) {
            return false;
        }
        StartDevEnvironmentSessionRequest other = (StartDevEnvironmentSessionRequest) obj;
        return Objects.equals(spaceName(), other.spaceName()) && Objects.equals(projectName(), other.projectName())
                && Objects.equals(id(), other.id()) && Objects.equals(sessionConfiguration(), other.sessionConfiguration());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("StartDevEnvironmentSessionRequest").add("SpaceName", spaceName())
                .add("ProjectName", projectName()).add("Id", id()).add("SessionConfiguration", sessionConfiguration()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "spaceName":
            return Optional.ofNullable(clazz.cast(spaceName()));
        case "projectName":
            return Optional.ofNullable(clazz.cast(projectName()));
        case "id":
            return Optional.ofNullable(clazz.cast(id()));
        case "sessionConfiguration":
            return Optional.ofNullable(clazz.cast(sessionConfiguration()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<StartDevEnvironmentSessionRequest, T> g) {
        return obj -> g.apply((StartDevEnvironmentSessionRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends CodeCatalystRequest.Builder, SdkPojo,
            CopyableBuilder<Builder, StartDevEnvironmentSessionRequest> {
        /**
         * <p>
         * The name of the space.
         * </p>
         * 
         * @param spaceName
         *        The name of the space.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder spaceName(String spaceName);

        /**
         * <p>
         * The name of the project in the space.
         * </p>
         * 
         * @param projectName
         *        The name of the project in the space.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder projectName(String projectName);

        /**
         * <p>
         * The system-generated unique ID of the Dev Environment.
         * </p>
         * 
         * @param id
         *        The system-generated unique ID of the Dev Environment.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder id(String id);

        /**
         * Sets the value of the SessionConfiguration property for this object.
         *
         * @param sessionConfiguration
         *        The new value for the SessionConfiguration property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sessionConfiguration(DevEnvironmentSessionConfiguration sessionConfiguration);

        /**
         * Sets the value of the SessionConfiguration property for this object.
         *
         * This is a convenience method that creates an instance of the
         * {@link DevEnvironmentSessionConfiguration.Builder} avoiding the need to create one manually via
         * {@link DevEnvironmentSessionConfiguration#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link DevEnvironmentSessionConfiguration.Builder#build()} is called
         * immediately and its result is passed to {@link #sessionConfiguration(DevEnvironmentSessionConfiguration)}.
         * 
         * @param sessionConfiguration
         *        a consumer that will call methods on {@link DevEnvironmentSessionConfiguration.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #sessionConfiguration(DevEnvironmentSessionConfiguration)
         */
        default Builder sessionConfiguration(Consumer<DevEnvironmentSessionConfiguration.Builder> sessionConfiguration) {
            return sessionConfiguration(DevEnvironmentSessionConfiguration.builder().applyMutation(sessionConfiguration).build());
        }

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends CodeCatalystRequest.BuilderImpl implements Builder {
        private String spaceName;

        private String projectName;

        private String id;

        private DevEnvironmentSessionConfiguration sessionConfiguration;

        private BuilderImpl() {
        }

        private BuilderImpl(StartDevEnvironmentSessionRequest model) {
            super(model);
            spaceName(model.spaceName);
            projectName(model.projectName);
            id(model.id);
            sessionConfiguration(model.sessionConfiguration);
        }

        public final String getSpaceName() {
            return spaceName;
        }

        public final void setSpaceName(String spaceName) {
            this.spaceName = spaceName;
        }

        @Override
        public final Builder spaceName(String spaceName) {
            this.spaceName = spaceName;
            return this;
        }

        public final String getProjectName() {
            return projectName;
        }

        public final void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        @Override
        public final Builder projectName(String projectName) {
            this.projectName = projectName;
            return this;
        }

        public final String getId() {
            return id;
        }

        public final void setId(String id) {
            this.id = id;
        }

        @Override
        public final Builder id(String id) {
            this.id = id;
            return this;
        }

        public final DevEnvironmentSessionConfiguration.Builder getSessionConfiguration() {
            return sessionConfiguration != null ? sessionConfiguration.toBuilder() : null;
        }

        public final void setSessionConfiguration(DevEnvironmentSessionConfiguration.BuilderImpl sessionConfiguration) {
            this.sessionConfiguration = sessionConfiguration != null ? sessionConfiguration.build() : null;
        }

        @Override
        public final Builder sessionConfiguration(DevEnvironmentSessionConfiguration sessionConfiguration) {
            this.sessionConfiguration = sessionConfiguration;
            return this;
        }

        @Override
        public Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration) {
            super.overrideConfiguration(overrideConfiguration);
            return this;
        }

        @Override
        public Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer) {
            super.overrideConfiguration(builderConsumer);
            return this;
        }

        @Override
        public StartDevEnvironmentSessionRequest build() {
            return new StartDevEnvironmentSessionRequest(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}