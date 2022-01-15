import axios from "axios";
import { useEffect, useState } from "react";
import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";
import { BASE_URL } from "utils/requests";
import { MoviePage } from "types/movie";

function Listing() {

   const [pageNumber, setPageNumber] = useState<MoviePage>(0);

   const [page, setPage] = useState({
      content: [],
      last: true,
      totalPages: 0,
      totalElements: 0,
      size: 12,
      number: 0,
      first: true,
      numberOfElements: 0,
      empty: true
   })

   useEffect(() => {
      axios.get(`${BASE_URL}/movies?size=12&page=${pageNumber}&sort=id`)
         .then(resposta => {
            const data = resposta.data as MoviePage;
            setPage(data);
         });
   }, [pageNumber]);

   return (
      <>
         <Pagination />

         <div className="conteiner">
            <div className="row">
               {page.content.map(movie => (
                  <div key={movie.id} className="col-sm-5 col-lg-4 col-xl-3 mb-3">
                     <MovieCard movie={movie} />
                  </div>
               )
               )}
            </div>
         </div>
      </>
   );


}

export default Listing; 