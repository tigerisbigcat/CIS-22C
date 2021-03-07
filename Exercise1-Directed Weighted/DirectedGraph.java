// 22C
// TTh 9:30-11:15
// Name : Lei Hao
// Exercise 1 - Directed Weighted

import StackAndQueuePackage.*;
import java.util.Iterator;

public class DirectedGraph<T> implements GraphInterface<T>
{
    private DictionaryInterface<T, VertexInterface<T>> vertices;
    private int edgeCount;

    public DirectedGraph()
    {
        vertices = new LinkedDictionary<>();
        edgeCount = 0;
    } // end default constructor


    protected void resetVertices()
    {
        Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
        while (vertexIterator.hasNext())
        {
            VertexInterface<T> nextVertex = vertexIterator.next();
            nextVertex.unvisit();
            nextVertex.setCost(0);
            nextVertex.setPredecessor(null);
        } // end while
    } // end resetVertices

    /** Adds a given vertex to this graph.
     @param vertexLabel  An object that labels the new vertex and is
     distinct from the labels of current vertices.
     @return  True if the vertex is added, or false if not. */
    public boolean addVertex(T vertexLabel) {
        VertexInterface<T> addOutcome = vertices.add(vertexLabel, new Vertex<>(vertexLabel));
        return addOutcome == null;
    }

    /** Adds a weighted edge between two given distinct vertices that
     are currently in this graph. The desired edge must not already
     be in the graph. In a directed graph, the edge points toward
     the second vertex given.
     @param begin  An object that labels the origin vertex of the edge.
     @param end    An object, distinct from begin, that labels the end
     vertex of the edge.
     @param edgeWeight  The real value of the edge's weight.
     @return  True if the edge is added, or false if not. */
    public boolean addEdge(T begin, T end, double edgeWeight) {
        boolean result =  false;
        VertexInterface<T> beginVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);
        if ((beginVertex != null) && (endVertex != null)) {
            result = beginVertex.connect(endVertex, edgeWeight);
        }
        if (result) {
            edgeCount++;
        }
        return result;
    }

    /** Adds an unweighted edge between two given distinct vertices
     that are currently in this graph. The desired edge must not
     already be in the graph. In a directed graph, the edge points
     toward the second vertex given.
     @param begin  An object that labels the origin vertex of the edge.
     @param end    An object, distinct from begin, that labels the end
     vertex of the edge.
     @return  True if the edge is added, or false if not. */
    public boolean addEdge(T begin, T end) {
        return addEdge(begin, end, 0);
    }

    /** Sees whether an edge exists between two given vertices.
     @param begin  An object that labels the origin vertex of the edge.
     @param end    An object that labels the end vertex of the edge.
     @return  True if an edge exists. */
    public boolean hasEdge(T begin, T end) {
        boolean found = false;
        VertexInterface<T> beginVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);
        if ((beginVertex != null) && (endVertex != null)) {
            Iterator<VertexInterface<T>> neighbors = beginVertex.getNeighborIterator();
            while (!found && neighbors.hasNext()) {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (endVertex.equals(nextNeighbor)) {
                    found = true;
                }
            }
        }
        return found;
    }

    /** Sees whether this graph is empty.
     @return  True if the graph is empty. */
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    /** Gets the number of vertices in this graph.
     @return  The number of vertices in the graph. */
    public int getNumberOfVertices() {
        return vertices.getSize();
    }

    /** Gets the number of edges in this graph.
     @return  The number of edges in the graph. */
    public int getNumberOfEdges() {
        return edgeCount;
    }

    /** Removes all vertices and edges from this graph. */
    public void clear() {
        vertices.clear();
        edgeCount = 0;
    }

    /** Performs a breadth-first traversal of this graph.
     @param origin  An object that labels the origin vertex of the traversal.
     @return  A queue of labels of the vertices in the traversal, with
     the label of the origin vertex at the queue's front. */
    public QueueInterface<T> getBreadthFirstTraversal(T origin) {
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<>();
        QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<>();
        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin);
        vertexQueue.enqueue(originVertex);
        while (!vertexQueue.isEmpty()) {
            VertexInterface<T> frontVertex = vertexQueue.dequeue();
            Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
            while (neighbors.hasNext()) {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (!nextNeighbor.isVisited()) {
                    nextNeighbor.visit();
                    traversalOrder.enqueue(nextNeighbor.getLabel());
                    vertexQueue.enqueue(nextNeighbor);
                }
            }
        }
        return traversalOrder;
    }


    public QueueInterface<T> getDepthFirstTraversal(T origin)
    {
        // Assumes graph is not empty
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<T>();
        StackInterface<VertexInterface<T>> vertexStack = new LinkedStack<>();

        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin); // Enqueue vertex label
        vertexStack.push(originVertex); // Enqueue vertex

        while (!vertexStack.isEmpty())
        {
            VertexInterface<T> topVertex = vertexStack.peek();
            VertexInterface<T> nextNeighbor = topVertex.getUnvisitedNeighbor();

            if (nextNeighbor != null)
            {
                nextNeighbor.visit();
                traversalOrder.enqueue(nextNeighbor.getLabel());
                vertexStack.push(nextNeighbor);
            }
            else // All neighbors are visited
                vertexStack.pop();
        } // end while

        return traversalOrder;
    } // end getDepthFirstTraversal

    public StackInterface<T> getTopologicalOrder()
    {
        resetVertices();

        StackInterface<T> vertexStack = new LinkedStack<>();
        int numberOfVertices = getNumberOfVertices();
        for (int counter = 1; counter <= numberOfVertices; counter++)
        {
            VertexInterface<T> nextVertex = findTerminal();
            nextVertex.visit();
            vertexStack.push(nextVertex.getLabel());
        } // end for

        return vertexStack;
    } // end getTopologicalOrder

    /** Precondition: path is an empty stack (NOT null) */
    public int getShortestPath(T begin, T end, StackInterface<T> path)
    {
        resetVertices();
        boolean done = false;
        QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<>();

        VertexInterface<T> originVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);

        originVertex.visit();
        // Assertion: resetVertices() has executed setCost(0)
        // and setPredecessor(null) for originVertex

        vertexQueue.enqueue(originVertex);

        while (!done && !vertexQueue.isEmpty())
        {
            VertexInterface<T> frontVertex = vertexQueue.dequeue();

            Iterator<VertexInterface<T>> neighbors =
                    frontVertex.getNeighborIterator();
            while (!done && neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();

                if (!nextNeighbor.isVisited())
                {
                    nextNeighbor.visit();
                    nextNeighbor.setCost(1 + frontVertex.getCost());
                    nextNeighbor.setPredecessor(frontVertex);
                    vertexQueue.enqueue(nextNeighbor);
                } // end if

                if (nextNeighbor.equals(endVertex))
                    done = true;
            } // end while
        } // end while

        // Traversal ends; construct shortest path
        int pathLength = (int)endVertex.getCost();
        path.push(endVertex.getLabel());

        VertexInterface<T> vertex = endVertex;
        while (vertex.hasPredecessor())
        {
            vertex = vertex.getPredecessor();
            path.push(vertex.getLabel());
        } // end while

        return pathLength;
    } // end getShortestPath


    /** Precondition: path is an empty stack (NOT null) */
    public double getCheapestPath(T begin, T end, StackInterface<T> path)
    {
        resetVertices();
        boolean done = false;

        // Use EntryPQ instead of Vertex because multiple entries contain
        // the same vertex but different costs - cost of path to vertex is EntryPQ's priority value
        PriorityQueueInterface<EntryPQ> priorityQueue = new HeapPriorityQueue<>();

        VertexInterface<T> originVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);

        priorityQueue.add(new EntryPQ(originVertex, 0, null));

        while (!done && !priorityQueue.isEmpty())
        {
            EntryPQ frontEntry = priorityQueue.remove();
            VertexInterface<T> frontVertex = frontEntry.getVertex();

            if (!frontVertex.isVisited())
            {
                frontVertex.visit();
                frontVertex.setCost(frontEntry.getCost());
                frontVertex.setPredecessor(frontEntry.getPredecessor());

                if (frontVertex.equals(endVertex))
                    done = true;
                else
                {
                    Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
                    Iterator<Double> edgeWeights = frontVertex.getWeightIterator();
                    while (neighbors.hasNext())
                    {
                        VertexInterface<T> nextNeighbor = neighbors.next();
                        Double weightOfEdgeToNeighbor = edgeWeights.next();

                        if (!nextNeighbor.isVisited())
                        {
                            double nextCost = weightOfEdgeToNeighbor + frontVertex.getCost();
                            priorityQueue.add(new EntryPQ(nextNeighbor, nextCost, frontVertex));
                        } // end if
                    } // end while
                } // end if
            } // end if
        } // end while

        // Traversal ends, construct cheapest path
        double pathCost = endVertex.getCost();
        path.push(endVertex.getLabel());

        VertexInterface<T> vertex = endVertex;
        while (vertex.hasPredecessor())
        {
            vertex = vertex.getPredecessor();
            path.push(vertex.getLabel());
        } // end while

        return pathCost;
    } // end getCheapestPath

    protected VertexInterface<T> findTerminal()
    {
        boolean found = false;
        VertexInterface<T> result = null;

        Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();

        while (!found && vertexIterator.hasNext())
        {
            VertexInterface<T> nextVertex = vertexIterator.next();

            // If nextVertex is unvisited AND has only visited neighbors)
            if (!nextVertex.isVisited())
            {
                if (nextVertex.getUnvisitedNeighbor() == null )
                {
                    found = true;
                    result = nextVertex;
                } // end if
            } // end if
        } // end while

        return result;
    } // end findTerminal

    // Used for testing
    public void displayEdges()
    {
        System.out.println("\nEdges exist from the first vertex in each line to the other vertices in the line.");
        System.out.println("(Edge weights are given; weights are zero for unweighted graphs):\n");
        Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
        while (vertexIterator.hasNext())
        {
            ((Vertex<T>)(vertexIterator.next())).display();
        } // end while
    } // end displayEdges

    private class EntryPQ implements Comparable<EntryPQ>
    {
        private VertexInterface<T> vertex;
        private VertexInterface<T> previousVertex;
        private double cost; // cost to nextVertex

        private EntryPQ(VertexInterface<T> vertex, double cost, VertexInterface<T> previousVertex)
        {
            this.vertex = vertex;
            this.previousVertex = previousVertex;
            this.cost = cost;
        } // end constructor

        public VertexInterface<T> getVertex()
        {
            return vertex;
        } // end getVertex

        public VertexInterface<T> getPredecessor()
        {
            return previousVertex;
        } // end getPredecessor

        public double getCost()
        {
            return cost;
        } // end getCost

        public int compareTo(EntryPQ otherEntry)
        {
        // Using opposite of reality since our priority queue uses a maxHeap;
        // could revise using a minheap
            return (int)Math.signum(otherEntry.cost - cost);
        } // end compareTo

        public String toString()
        {
            return vertex.toString() + " " + cost;
        } // end toString
    } // end EntryPQ
} // end DirectedGraph