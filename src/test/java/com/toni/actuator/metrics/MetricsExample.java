package com.toni.actuator.metrics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Meter.Type;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

class MetricsExample {
	
	private MeterRegistry registry = new SimpleMeterRegistry();
	
	@Test
	public void givenGlobalRegistry_whenIncrementAnywhere_thenCounted() {
	    class CountedObject {
	        private CountedObject() {
	            Metrics.counter("objects.instance").increment(1.0);
	        }
	    }
	    Metrics.addRegistry(new SimpleMeterRegistry());
	 
	    Metrics.counter("objects.instance").increment();
	    new CountedObject();
	 
	    Optional<Counter> counterOptional = Optional.ofNullable(Metrics.globalRegistry
	      .find("objects.instance").counter());
	    assertTrue(counterOptional.isPresent());
	    assertEquals( 2.0, counterOptional.get().count());
	}

	@Test
	public void counter() {	
		Counter counter = Counter
				  .builder("instance")
				  .description("indicates instance count of the object")
				  .tags("dev", "performance")
				  .register(registry);
				 
				counter.increment(2.0);
				 
				assertEquals(2 , counter.count());
				 
				counter.increment(1);
				
				assertEquals(3, counter.count());
				
				//counter.increment(-1);
				//assertTrue(counter.count() == 2);
	}
	
	@Test
	void timer() {
		SimpleMeterRegistry registry = new SimpleMeterRegistry();
		Timer timer = registry.timer("app.event");
		timer.record(() -> {
		    try {
		        TimeUnit.MILLISECONDS.sleep(1500);
		    } catch (InterruptedException ignored) { }
		});
		 
		timer.record(3000, TimeUnit.MILLISECONDS);
		 
		assertEquals(2, timer.count());
		//assertTrue(4510 > timer.totalTime( TimeUnit.MILLISECONDS) && 4500 <= timer.totalTime( TimeUnit.MILLISECONDS));
	}
	
//	@Test
//	public void longtimer() {
//		SimpleMeterRegistry registry = new SimpleMeterRegistry();
//		LongTaskTimer longTaskTimer = LongTaskTimer
//		  .builder("3rdPartyService")
//		  .register(registry);
//		 
//		Sample currentTaskId = longTaskTimer.start();
//		try {
//		    TimeUnit.SECONDS.sleep(2);
//		} catch (InterruptedException ignored) { }
//		long timeElapsed = longTaskTimer.stop(currentTaskId);
//		 
//		assertTrue(timeElapsed / (int) 1e9 == 2);
//	}
	
	@Test
	void gauge() {
		SimpleMeterRegistry registry = new SimpleMeterRegistry();
		List<String> list = new ArrayList<>(4);
		 
		Gauge gauge = Gauge
		  .builder("cache.size", list, List::size)
		  .register(registry);
		 
		assertEquals( 0.0, gauge.value());
		 
		list.add("1");
		 
		assertEquals(1.0, gauge.value());
	}
	
	@Test
	void distribSummary() {
		SimpleMeterRegistry registry = new SimpleMeterRegistry();
		DistributionSummary distributionSummary = DistributionSummary
		  .builder("request.size")
		  .baseUnit("bytes")
		  .register(registry);
		 
		distributionSummary.record(3);
		distributionSummary.record(4);
		distributionSummary.record(5);
		 
		assertEquals(3, distributionSummary.count());
		assertEquals(12, distributionSummary.totalAmount());
	}
	
//	@Test
//	void distribSummaryTimer() {
//		SimpleMeterRegistry registry = new SimpleMeterRegistry();
//		Timer timer = Timer.builder("test.timer")
//		  .quantiles(WindowSketchQuantiles
//		    .quantiles(0.3, 0.5, 0.95)
//		    .create())
//		  .register(registry);
//	}
	
//	@Test
//	void quantilesGauges(){
//		List<Gauge> quantileGauges = registry.getMeters().stream()
//				  .filter(m -> m.getType().name().equals("Gauge"))
//				  .map(meter -> (Gauge) meter)
//				  .collect(Collectors.toList());
//				 
//				assertTrue(3 == quantileGauges.size());
//				 
//				Map<String, Integer> quantileMap = extractTagValueMap(registry, Type.Gauge, 1e9);
//				assertThat(quantileMap, allOf(
//				  hasEntry("quantile=0.3",2),
//				  hasEntry("quantile=0.5", 3),
//				  hasEntry("quantile=0.95", 8)));
//	}
}
