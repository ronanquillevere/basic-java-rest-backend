package com.github.ronanquillevere.airetest1.interfaces.rest.v1.converter;
//package com.mycomosi.topo.interfaces.rest.v1.converter;
//
//import java.util.List;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//import com.google.common.collect.Lists;
//import com.mycomosi.topo.domain.Edge;
//import com.mycomosi.topo.domain.IsGraph;
//import com.mycomosi.topo.domain.KeyValue;
//import com.mycomosi.topo.domain.ModelInstance;
//import com.mycomosi.topo.domain.ModelInstancePreview;
//import com.mycomosi.topo.domain.NavEndpoint;
//import com.mycomosi.topo.domain.Navigation;
//import com.mycomosi.topo.domain.PagedResult;
//import com.mycomosi.topo.domain.Vertex;
//import com.mycomosi.topo.interfaces.dto.EdgeDto;
//import com.mycomosi.topo.interfaces.dto.EndpointDto;
//import com.mycomosi.topo.interfaces.dto.GraphDto;
//import com.mycomosi.topo.interfaces.dto.IdDto;
//import com.mycomosi.topo.interfaces.dto.KeyValueDto;
//import com.mycomosi.topo.interfaces.dto.NavEndpointDto;
//import com.mycomosi.topo.interfaces.dto.NavigationDto;
//import com.mycomosi.topo.interfaces.dto.PagedResultDto;
//import com.mycomosi.topo.interfaces.dto.VertexDto;
//
//public class GraphConverter
//{
//
//   private static GraphConverter INSTANCE = new GraphConverter();
//   private static FromVertexFunction VERTEX_MAPPER = new FromVertexFunction();
//   private static FromEdgeFunction EDGE_MAPPER = new FromEdgeFunction();
//   @SuppressWarnings("rawtypes")
//   private static FromGraphFunction GRAPH_MAPPER = new FromGraphFunction();
//   private static FromNavigationFunction<Navigation> NAVIGATION_MAPPER = new FromNavigationFunction<Navigation>();
//   @SuppressWarnings("rawtypes")
//   private static FromPageResultFunction PAGED_RESULT_MAPPER = new FromPageResultFunction();
//
//   private GraphConverter()
//   {}
//
//   public GraphConverter getInstance()
//   {
//      return INSTANCE;
//   }
//
//   private static <FROM, TO> List<TO> toList(List<FROM> inputList, Function<FROM, TO> mapper)
//   {
//      return inputList.stream().map(mapper).collect(Collectors.toList());
//   }
//
//   private static class FromVertexFunction implements Function<Vertex, VertexDto>
//   {
//      @Override
//      public VertexDto apply(Vertex vertex)
//      {
//         return GraphConverter.fromVertex(vertex);
//      }
//   }
//
//   private static class FromEdgeFunction implements Function<Edge, EdgeDto>
//   {
//      @Override
//      public EdgeDto apply(Edge edge)
//      {
//         return GraphConverter.fromEdge(edge);
//      }
//   }
//
//   private static class FromGraphFunction<T extends IsGraph> implements Function<T, GraphDto>
//   {
//      @Override
//      public GraphDto apply(T graph)
//      {
//         if (graph instanceof ModelInstance)
//            return new GraphDto(
//               GraphConverter.fromVertices(graph.getVertices()),
//               GraphConverter.fromEdges(graph.getEdges()),
//               ((ModelInstance) graph).getId(),
//               ((ModelInstance) graph).getName());
//         else
//            return new GraphDto(GraphConverter.fromVertices(graph.getVertices()), GraphConverter.fromEdges(graph.getEdges()), "", "");
//      }
//   }
//
//   private static class FromPageResultFunction<T extends PagedResult> implements Function<T, PagedResultDto>
//   {
//
//      @Override
//      public PagedResultDto<ModelInstancePreview> apply(T page)
//      {
//         return new PagedResultDto<ModelInstancePreview>(page.getTotal(), page.getCount(), page.getOffset(), page.getResults());
//      }
//
//   }
//
//   private static class FromNavigationFunction<T extends Navigation> implements Function<T, NavigationDto>
//   {
//      @Override
//      public NavigationDto apply(T nav)
//      {
//         return new NavigationDto(
//            nav.getId(),
//            nav.getRelationships(),
//            nav.getType(),
//            GraphConverter.fromNavEndpoint(nav.getFrom()),
//            GraphConverter.fromNavEndpoint(nav.getTo()),
//            nav.isDefaultConfiguration(),
//            nav.isActivated());
//      }
//   }
//
//   public static VertexDto fromVertex(Vertex vertex)
//   {
//      List<KeyValueDto> attrs = Lists.newArrayList();
//
//      List<KeyValue> attributes = vertex.getAttributes();
//      if (attributes != null)
//      {
//         for (KeyValue kv : attributes)
//         {
//            attrs.add(new KeyValueDto(kv.getKey(), kv.getValue()));
//         }
//      }
//
//      return new VertexDto(vertex.getId(), vertex.getLabel(), attrs);
//   }
//
//   public static EdgeDto fromEdge(Edge edge)
//   {
//      List<KeyValueDto> attrs = Lists.newArrayList();
//
//      List<KeyValue> attributes = edge.getAttributes();
//      if (attributes != null)
//      {
//         for (KeyValue kv : attributes)
//         {
//            attrs.add(new KeyValueDto(kv.getKey(), kv.getValue()));
//         }
//      }
//
//      return new EdgeDto(edge.getId(), edge.getLabel(), new EndpointDto(edge.getFrom().getId()), new EndpointDto(edge.getTo().getId()), attrs);
//   }
//
//   public static NavEndpointDto fromNavEndpoint(NavEndpoint navEndpoint)
//   {
//      if (navEndpoint == null)
//         return new NavEndpointDto("");
//      return new NavEndpointDto(navEndpoint.getClassName());
//   }
//
//   public static List<VertexDto> fromVertices(List<Vertex> vertices)
//   {
//      return toList(vertices, VERTEX_MAPPER);
//   }
//
//   public static List<EdgeDto> fromEdges(List<Edge> edges)
//   {
//      return toList(edges, EDGE_MAPPER);
//   }
//
//   @SuppressWarnings("unchecked")
//   public static GraphDto fromGraph(IsGraph graph)
//   {
//      return GRAPH_MAPPER.apply(graph);
//   }
//
//   @SuppressWarnings("unchecked")
//   public static <T extends IsGraph> List<GraphDto> fromGraphs(List<T> graphs)
//   {
//      return toList(graphs, GRAPH_MAPPER);
//   }
//
//   @SuppressWarnings("unchecked")
//   public static PagedResultDto<ModelInstancePreview> fromPagedResult(PagedResult<ModelInstancePreview> page)
//   {
//      return PAGED_RESULT_MAPPER.apply(page);
//   }
//
//   public static NavigationDto fromMavigation(Navigation nav)
//   {
//      return NAVIGATION_MAPPER.apply(nav);
//   }
//
//   public static IdDto fromId(String id)
//   {
//      return new IdDto(id);
//   }
//}
