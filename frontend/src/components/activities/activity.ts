export type Activity = {
  id: string;
  eventname: string;
  description: string;
  date: string;
  imageurl: string;
  largeimageurl: string;
  xlargeimageurl: string;
  link: string;
  venue: {
    name: string;
    town: string;
  };
  ticketpricing: {
    minPrice: number;
    maxPrice: number;
  };
};

export type ActivityResponse = {
  results: Activity[];
};
