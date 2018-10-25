package software.amazon.awssdk.benchmark.ec2;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import software.amazon.awssdk.protocols.query.AwsEc2ProtocolFactory;
import software.amazon.awssdk.services.ec2.model.RunInstancesRequest;
import software.amazon.awssdk.services.ec2.transform.RunInstancesRequestMarshaller;

public class V2Ec2MarshallerBenchmark {

    @Benchmark
    public Object marshall(MarshallerState s) {
        return runInstancesRequestMarshaller().marshall(s.getReq());
    }

    @State(Scope.Benchmark)
    public static class MarshallerState {
        @Param( {"TINY", "SMALL", "HUGE"})
        private TestItem testItem;

        private RunInstancesRequest req;

        @Setup
        public void setup() {
            req = testItem.getValue();
        }

        public RunInstancesRequest getReq() {
            return req;
        }
    }

    public enum TestItem {
        TINY,
        SMALL,
        HUGE;

        private static final V2ItemFactory factory = new V2ItemFactory();

        private RunInstancesRequest request;

        static {
            TINY.request = factory.tiny();
            SMALL.request = factory.small();
            HUGE.request = factory.huge();
        }

        public RunInstancesRequest getValue() {
            return request;
        }
    }

    private static final AwsEc2ProtocolFactory PROTOCOL_FACTORY = new AwsEc2ProtocolFactory();

    private static final RunInstancesRequestMarshaller RUN_INSTANCES_REQUEST_MARSHALLER
        = new RunInstancesRequestMarshaller(PROTOCOL_FACTORY);

    public static RunInstancesRequestMarshaller runInstancesRequestMarshaller() {
        return RUN_INSTANCES_REQUEST_MARSHALLER;
    }

}
