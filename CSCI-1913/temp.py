costs = {'Philadelphia':{'Chicago':227, 'Dallas':289},
         'Chicago':{'Philadelphia':227, 'Dallas':105, 'Las Vegas':56},
         'Dallas':{'Philadelphia':289, 'Houston':173, 'Chicago':105,
                   'Las Vegas':44, 'San Diego':303},
         'Houston':{'Dallas':173},
         'Las Vegas':{'Chicago':56, 'Dallas':44, 'San Diego':74,
                      'Los Angeles':44, 'San Francisco':56},
         'Los Angeles':{'Las Vegas':44, 'San Diego':157,
                        'San Francisco':111},
         'San Diego':{'Las Vegas':44, 'Los Angeles':157, 'Dallas':303},
         'San Francisco':{'Las Vegas':56, 'Los Angeles':111}}

def cheapest(costs, origin, destination):
    """
    :param costs: cost dictionary
    :param origin: String origin
    :param destination: String destination
    :return: float the cheapest cost travelling from origin to destination, fload('inf') if none exist
    """
    cheap = float('inf')
    # Direct route
    if destination in costs[origin]:
        cheap = costs[origin][destination]
    # Intermediate route
    for ele in costs[origin]:
        # If the intermediate step leads to destination
        if destination in costs[ele] and ele != origin:
            total_cost = costs[origin][ele] + costs[ele][destination]
            if total_cost < cheap:
                cheap = total_cost
    return cheap

print(cheapest(costs, 'San Francisco', 'Philadelphia'))
print(cheapest(costs, 'Chicago', 'Dallas'))
print(cheapest(costs, 'Las Vegas', 'Los Angeles'))
print(cheapest(costs, 'Philadelphia', 'Las Vegas'))
